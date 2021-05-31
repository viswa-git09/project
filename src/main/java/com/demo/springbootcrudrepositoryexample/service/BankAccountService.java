/*
 * package com.demo.springbootcrudrepositoryexample.service;
 * 
 * import javax.persistence.EntityManager; import
 * javax.persistence.EntityManagerFactory;
 * 
 * import com.demo.springbootcrudrepositoryexample.entity.BankAccount; import
 * com.demo.springbootcrudrepositoryexample.entity.MainAccounts; import
 * com.demo.springbootcrudrepositoryexample.entity.RelatedAccount;
 * 
 * public class BankAccountService {
 * 
 * private EntityManagerFactory emf; // injected via constructor
 * 
 * public void transfer(MonetaryAmount amount) { EntityManager em =
 * emf.createEntityManager(); try { em.getTransaction().begin(); BankAccount
 * fromAccount = em.find(MainAccounts.class); BankAccount toAccount =
 * em.find(RelatedAccount.class); fromAccount.debit(amount);
 * toAccount.credit(amount); em.getTransaction().commit();
 * 
 * } catch(Exception e) { em.getTransaction().rollback(); // handle exception
 * (possibly rethrowing it) } finally { em.close(); } }
 * 
 * public void credit(MonetaryAmount amount, AccountId) { EntityManager em =
 * emf.createEntityManager(); try { em.getTransaction().begin(); BankAccount
 * theAccount = em.find(BankAccount.class); theAccount.credit(amount);
 * em.getTransaction().commit();
 * 
 * } catch(Exception e) { em.getTransaction().rollback(); // handle exception
 * (possibly rethrowing it) } finally { em.close(); } }
 * 
 * public void debit(MonetaryAmount amount, AccountId){ EntityManager em =
 * emf.createEntityManager(); try { em.getTransaction().begin(); BankAccount
 * theAccount = em.find(BankAccount.class, ...); theAccount.debit(amount);
 * em.getTransaction().commit();
 * 
 * } catch(Exception e) { em.getTransaction().rollback(); // handle exception
 * (possibly rethrowing it) } finally { em.close(); } }
 * 
 * }
 */