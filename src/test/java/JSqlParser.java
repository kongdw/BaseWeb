/**
 * @author David Kong
 * @version 1.0
 */
//public class JSqlParser {
//
//
//    public static void main(String[] args) throws JSQLParserException {
//        String sql = "select a.name,b.name from table1 a,table2 b where a.id = b.id and (b.name like '%123' or b.name like '%456') and b.name ='111' order by a.id" ;
//        Statement statement = CCJSqlParserUtil.parse(sql);
//        Select select = (Select) statement;
//        PlainSelect selectBody = (PlainSelect)select.getSelectBody();
//        Expression where = selectBody.getWhere();
//        EqualsTo equalsTo = new EqualsTo();
//        equalsTo.setLeftExpression(new Column("a.id"));
//        equalsTo.setRightExpression(new LongValue(1));
//        AndExpression and = new AndExpression(where,equalsTo);
//        selectBody.setWhere(and);
//        //WhereUtil.add(Expression ex,)
//
//        System.out.println(selectBody);
//
//    }
//}
