package k0n9.comm.servlet;

import com.google.inject.Inject;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.Reader;

public class HsqlDbSetupServlet extends HttpServlet {

	private static final Logger log = LoggerFactory.getLogger(HsqlDbSetupServlet.class);

	private SqlSessionManager sqlSessionManager;

	@Inject
	public HsqlDbSetupServlet(final SqlSessionManager sqlSessionManager) throws IOException {
		this.sqlSessionManager = sqlSessionManager;
		buildDatabase();
	}

	private void buildDatabase() throws IOException {
		SqlSession sqlSession = sqlSessionManager.openSession();
		try {
			final ScriptRunner scriptRunner = new ScriptRunner(sqlSession.getConnection());
			buildSchema(scriptRunner);
			populateData(scriptRunner);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	private void populateData(final ScriptRunner scriptRunner) throws IOException {
		Reader dataloadReader = null;
		try {
			dataloadReader = Resources.getResourceAsReader("k0n9/database/dataload.sql");
			scriptRunner.runScript(dataloadReader);
		} finally {
			IOUtils.closeQuietly(dataloadReader);
		}
	}

	private void buildSchema(final ScriptRunner scriptRunner) throws IOException {
		Reader schemaReader = null;
		try {
			schemaReader = Resources.getResourceAsReader("k0n9/database/schema.sql");
			scriptRunner.runScript(schemaReader);
		} finally {
			IOUtils.closeQuietly(schemaReader);
		}
	}

}
