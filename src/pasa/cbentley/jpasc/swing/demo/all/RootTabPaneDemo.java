package pasa.cbentley.jpasc.swing.demo.all;

import pasa.cbentley.jpasc.pcore.domain.java.PublicKeyJava;
import pasa.cbentley.jpasc.pcore.interfaces.IAccessPascal;
import pasa.cbentley.jpasc.pcore.rpc.model.Account;
import pasa.cbentley.jpasc.pcore.rpc.model.Block;
import pasa.cbentley.jpasc.pcore.rpc.model.PublicKey;
import pasa.cbentley.jpasc.swing.interfaces.IRootTabPane;

public class RootTabPaneDemo implements IRootTabPane {

   public Integer getAccountNext(Integer account) {
      throw new RuntimeException("not implemented");
   }

   public Integer getAccountLast() {
      throw new RuntimeException("not implemented");
   }

   public Integer getAccountPrev(Integer account) {
      throw new RuntimeException("not implemented");
   }

   public Integer getBlockNext(Integer block) {

      throw new RuntimeException("not implemented");
   }

   public Integer getBlockPrev(Integer block) {

      throw new RuntimeException("not implemented");
   }

   public Integer getBlockLast() {

      throw new RuntimeException("not implemented");
   }

   public IAccessPascal getAccessPascal() {

      throw new RuntimeException("not implemented");
   }

   public void showAccountDetails(Account ac) {
      throw new RuntimeException("not implemented");
   }

   public void showAccountDetails(Integer ac) {
      throw new RuntimeException("not implemented");
   }

   public void showAccountOwner(Account ac) {
      throw new RuntimeException("not implemented");
   }

   public void showAccountOwner(Integer ac) {
      throw new RuntimeException("not implemented");
   }

   public void showBlock(Block ac) {
      throw new RuntimeException("not implemented");
   }

   public void showBlockDetails(Block ac) {
      throw new RuntimeException("not implemented");
   }

   public void showPublicKeyAccounts(PublicKey pk) {
      throw new RuntimeException("not implemented");
   }

   public void showPublicKeyJavaAccountNames(PublicKeyJava pk) {
      throw new RuntimeException("not implemented");
   }

   public void showPublicKeyJavaAccounts(PublicKeyJava pk) {
      throw new RuntimeException("not implemented");
   }

}
