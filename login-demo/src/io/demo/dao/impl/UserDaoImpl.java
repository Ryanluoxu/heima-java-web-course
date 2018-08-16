package io.demo.dao.impl;


import org.dom4j.Document;
import org.dom4j.Element;

import io.demo.dao.UserDao;
import io.demo.domain.User;
import io.demo.utils.XmlUtils;

public class UserDaoImpl implements UserDao {
	
	/* (non-Javadoc)
	 * @see io.demo.dao.impl.UserDao#addUser(io.demo.domain.User)
	 */
	@Override
	public void addUser(User user) {
		try {
			Document doc = XmlUtils.getDocument();
			Element root = doc.getRootElement();
			Element userNode = root.addElement("user");
			userNode.setAttributeValue("id", user.getId());
			userNode.setAttributeValue("username", user.getUsername());
			userNode.setAttributeValue("password", user.getPassword());
			userNode.setAttributeValue("email", user.getEmail());
			
			XmlUtils.updateXML(doc);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	/* (non-Javadoc)
	 * @see io.demo.dao.impl.UserDao#getUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User getUser(String username, String password) {
		try {
			Document doc = XmlUtils.getDocument();
			Element e = (Element) doc.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
			if (e==null) {
				return null;
			}
			
			User user = new User();
			user.setId(e.attributeValue("id"));
			user.setUsername(e.attributeValue("username"));
			user.setPassword(e.attributeValue("password"));
			user.setEmail(e.attributeValue("email"));
			
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	/* (non-Javadoc)
	 * @see io.demo.dao.impl.UserDao#checkUser(java.lang.String)
	 */
	@Override
	public boolean checkUser(String username) {
		try {
			Document doc = XmlUtils.getDocument();
			Element e = (Element) doc.selectSingleNode("//user[@username='"+username+"']");
			if (e==null) {
				return false;
			}
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}

}
