package common.model;

import common.model.connections.Entitlement;
import org.hibernate.Session;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class DatabaseObject {

    public List select(String sql, Object valueObject) throws Exception {
        Session session = Entitlement.getSessionFactory().openSession();
        session.beginTransaction();
        List<Object[]> list = session.createSQLQuery(sql).setProperties(valueObject).list();
        session.close();
        return list;
    }

    public long insert(String sql, Object valueObject) throws Exception {
        Session session = Entitlement.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery(sql)
                .setProperties(valueObject).executeUpdate();
        long result = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()")
                .uniqueResult()).longValue();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public int update(String sql, Object valueObject) throws Exception {
        Session session = Entitlement.getSessionFactory().openSession();
        session.beginTransaction();
        int result = session.createSQLQuery(sql)
                .setProperties(valueObject).executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public int delete(String sql, Object valueObject) throws Exception {
        Session session = Entitlement.getSessionFactory().openSession();
        session.beginTransaction();
        int result = session.createSQLQuery(sql)
                .setProperties(valueObject).executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public List<List<Object[]>> selectMultiple(String sqls, Object valueObject) throws Exception {
        String[] queries = sqls.split(";");
        List<List<Object[]>> result = new ArrayList<>();
        for(int i=0; i<queries.length; i++) {
            result.add(this.select(queries[i], valueObject));
        }
        return result;
    }
}

//for(Object[] userVO:list) {
//    System.out.println(userVO[1]);
//}

//for(List<Object[]> outer:result) {
//    for(Object[] inner:outer) {
//    System.out.println(inner[1]);
//    }
//}