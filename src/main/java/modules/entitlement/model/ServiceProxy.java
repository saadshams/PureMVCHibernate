package modules.entitlement.model;

import common.model.DatabaseObject;
import modules.entitlement.model.vo.UserVO;
import org.puremvc.java.multicore.patterns.proxy.Proxy;

import java.util.List;

public class ServiceProxy extends Proxy {

    public static String NAME = "ServiceProxy";
    private DatabaseObject databaseObject;

    public ServiceProxy() {
        super(NAME, null);
        databaseObject = new DatabaseObject();
    }

    public Object select() throws Exception {
        String sql = "SELECT * FROM user;";
        UserVO valueObject = new UserVO();
        return databaseObject.select(sql, valueObject);
    }

    public long insert() throws Exception {
        String sql = "INSERT INTO user(emailAddress, password, authToken) VALUES(:emailAddress, :password, :authToken)";
        UserVO valueObject = new UserVO(Math.random() + "@yahoo.com", "1243", "token1");
        return databaseObject.insert(sql, valueObject);
    }

    public long update() throws Exception {
        String sql = "UPDATE user SET emailAddress = :emailAddress, password = :password, authToken = :authToken WHERE id = :id";
        UserVO valueObject = new UserVO(3, "new@yahoo.com", "new", "new token");
        return databaseObject.update(sql, valueObject);
    }

    public long delete() throws Exception {
        String sql = "DELETE FROM user WHERE id = :id";
        UserVO valueObject = new UserVO(5);
        return databaseObject.delete(sql, valueObject);
    }

    public List<List<Object[]>> selectMultiple() throws Exception {
        String sql = "SELECT * FROM user;SELECT * FROM product;";
        UserVO valueObject = new UserVO(5);
        return databaseObject.selectMultiple(sql, valueObject);
    }

}