package edu.neu.cs5200.orm.jpa.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import edu.neu.cs5200.orm.jpa.entities.Admin;
import edu.neu.cs5200.orm.jpa.entities.User;

public class AdminDao extends UserDao {

	public AdminDao() {
		super();
	}

	public int createAdmin(Admin admin) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(admin);
		em.flush();
		try {
			em.getTransaction().commit();
		} catch (RollbackException ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return admin.getId();
	}

	public Admin findAdminById(int id) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Admin admin = em.find(Admin.class, id);
		try {
			em.getTransaction().commit();
		} catch (RollbackException ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return admin;
	}

	public List<Admin> findAllAdmin() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("select a from Admin a", Admin.class);
		List<Admin> admins = query.getResultList();
		try {
			em.getTransaction().commit();
		} catch (RollbackException ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return admins;
	}

	public void updateAdmin(int id, Admin newAdmin) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Admin old = em.find(Admin.class, id);
		old.setUsername(newAdmin.getUsername());
		old.setPassword(newAdmin.getPassword());
		old.setEmail(newAdmin.getEmail());
		em.merge(old);
		try {
			em.getTransaction().commit();
		} catch (RollbackException ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

	public void deleteAllAdmins() {
		List<Admin> list = findAllAdmin();
		for (Admin admin : list) {
			deleteAdmin(admin.getId());
		}
	}

	public void deleteAdmin(int id) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Admin.class, id));
		try {
			em.getTransaction().commit();
		} catch (RollbackException ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	public int createUser(User user) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(user);
		em.flush();
		try {
			em.getTransaction().commit();
		} catch (RollbackException ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return user.getId();
	}

	public User findUserById(int id) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		User user = em.find(User.class, id);
		try {
			em.getTransaction().commit();
		} catch (RollbackException ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return user;
	}

	public List<User> findAllUser() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("select u from User u", User.class);
		List<User> users = query.getResultList();
		try {
			em.getTransaction().commit();
		} catch (RollbackException ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return users;
	}

	public void updateUser(int id, User newUser) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		User old = em.find(User.class, id);
		old.setUsername(newUser.getUsername());
		old.setPassword(newUser.getPassword());
		old.setEmail(newUser.getEmail());
		em.merge(old);
		try {
			em.getTransaction().commit();
		} catch (RollbackException ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

	public void deleteAllUsers() {
		List<User> list = findAllUser();
		for (User user : list) {
			deleteUser(user.getId());
		}
	}

	public void deleteUser(int id) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(User.class, id));
		try {
			em.getTransaction().commit();
		} catch (RollbackException ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
}
