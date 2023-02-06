/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.swing.demo.run;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.BaseDLogger;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLogConfig;
import pasa.cbentley.core.src4.logging.ITechConfig;
import pasa.cbentley.core.src4.logging.ITechLvl;
import pasa.cbentley.core.src4.logging.ITechTags;
import pasa.cbentley.jpasc.appswing.ctx.PascAppCtx;
import pasa.cbentley.jpasc.pcore.rpc.model.PublicKey;
import pasa.cbentley.jpasc.swing.demo.all.RootTabPaneDemo;
import pasa.cbentley.jpasc.swing.demo.all.TabDemo;
import pasa.cbentley.jpasc.swing.demo.ctx.PascDemoCtx;
import pasa.cbentley.jpasc.swing.panels.helpers.PanelHelperKeyWalletNoWildcards;
import pasa.cbentley.jpasc.swing.panels.helpers.PanelHelperKeyWalletSwitch;
import pasa.cbentley.jpasc.swing.panels.table.account.TablePanelAccountWalletKey;
import pasa.cbentley.swing.actions.IExitable;
import pasa.cbentley.swing.imytab.IMyTab;
import pasa.cbentley.swing.utils.PrefIdable;

/**
 * One Class All Code For the Quick Demo Testing of single components
 * 
 * @author Charles Bentley
 *
 */
public class RunDemoAccountWalletKey extends RunJPascDemoAbstract implements IExitable {

   public static void main(final String[] args) {
      RunDemoAccountWalletKey runner = new RunDemoAccountWalletKey();
      runner.startPreUI();
      runner.startUI();

   }

   private TablePanelAccountWalletKey mainTab;

   private PascDemoCtx                pdc;

   /**
    * Super constructor initializes all the contexts
    */
   public RunDemoAccountWalletKey() {
      super();
      pdc = (PascDemoCtx) this.pac;
   }

   protected PascAppCtx createCtx() {
      return new PascDemoCtx(psc, this);
   }

   public IMyTab createMainTab() {
      if (mainTab == null) {
         mainTab = new TablePanelAccountWalletKey(psc, new RootTabPaneDemo());
      }
      return mainTab;
   }

   public Image getLogo64() {
      Image image = psc.createImage("/icons/logo/logo_demo_keys_greenorange_64.png", "");
      return image;
   }

   protected String getWelcomeMessage() {
      return "Welcome to the Demo of Wallet Key Selector";
   }

   public void initTab(TabDemo tabDemo) {
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, RunDemoAccountWalletKey.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, RunDemoAccountWalletKey.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }

   /**
    * setup the logger at. sub class may override.
    * Default opens all at finest level
    */
   protected void toStringSetupLogger(UCtx uc) {
      BaseDLogger loggerFirst = (BaseDLogger) uc.toDLog();
      IDLogConfig config = loggerFirst.getDefault().getConfig();
      config.setLevelGlobal(ITechLvl.LVL_03_FINEST);
      config.setFlagTag(ITechTags.FLAG_09_PRINT_FLOW, true);

      config.setFlagPrint(ITechConfig.MASTER_FLAG_08_OPEN_ALL_BUT_FALSE, true);
      //negatives
      config.setFlagTagNeg(ITechTags.FLAG_07_PRINT_EVENT, true);
   }


   //#enddebug

}
