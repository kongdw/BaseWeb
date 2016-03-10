package k0n9.module.sys;

import k0n9.commons.utils.IpUtils;
import k0n9.commons.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author David Kong
 * @version 1.0
 */
public class UserLogUtils {

    private static final Logger SYS_USER_LOGGER = LoggerFactory.getLogger("k0n9-sys-user");

    private Logger getSysUserLog() {
        return SYS_USER_LOGGER;
    }

    /**
     * 记录格式 [ip][用户名][操作][错误消息]
     * <p>
     * 注意操作如下：
     * loginError 登录失败
     * loginSuccess 登录成功
     * passwordError 密码错误
     * changePassword 修改密码
     * changeStatus 修改状态
     *
     * @param username
     * @param op
     * @param msg
     * @param args
     */
    public static void log(HttpServletRequest request, String username, String op, String msg, Object... args) {
        StringBuilder s = new StringBuilder();
        s.append(LogUtils.getBlock(getIp(request)));
        s.append(LogUtils.getBlock(username));
        s.append(LogUtils.getBlock(op));
        s.append(LogUtils.getBlock(msg));

        SYS_USER_LOGGER.info(s.toString(), args);
    }

    public static Object getIp(HttpServletRequest request) {
        return IpUtils.getIpAddr(request);
    }
}
