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
import pasa.cbentley.jpasc.pcore.ctx.IPascalCoinClientFactory;
import pasa.cbentley.jpasc.pcore.ctx.ITechPCore;
import pasa.cbentley.jpasc.pcore.rpc.model.PublicKey;
import pasa.cbentley.jpasc.swing.cmds.ICmdIDs;
import pasa.cbentley.jpasc.swing.demo.all.TabDemo;
import pasa.cbentley.jpasc.swing.demo.ctx.PascDemoCtx;
import pasa.cbentley.jpasc.swing.menu.MenuBarPascalDemo;
import pasa.cbentley.jpasc.swing.panels.core.PanelTabLoginConsole;
import pasa.cbentley.jpasc.swing.panels.helpers.PanelHelperKeyWalletNoWildcards;
import pasa.cbentley.jpasc.swing.panels.helpers.PanelHelperKeyWalletSwitch;
import pasa.cbentley.swing.actions.IExitable;
import pasa.cbentley.swing.cmd.ICommandableRefresh;
import pasa.cbentley.swing.imytab.IMyTab;
import pasa.cbentley.swing.utils.PrefIdable;
import pasa.cbentley.swing.window.CBentleyFrame;

/**
 * One Class All Code For the Quick Demo Testing of single components
 * 
 * @author Charles Bentley
 *
 */
public class RunDemoKeyWalletWild extends RunJPascDemoAbstract implements IExitable, ICommandableRefresh {

   public static void main(final String[] args) {
      RunDemoKeyWalletWild runner = new RunDemoKeyWalletWild();
      runner.startPreUI();
      runner.startUI();
     
   }


   private TabDemo                         mainTab;

   private PanelHelperKeyWalletNoWildcards panelHelperKeyWalletNoW;

   private PascDemoCtx                     pdc;

   /**
    * Super constructor initializes all the contexts
    */
   public RunDemoKeyWalletWild() {
      super();
      pdc = (PascDemoCtx)this.pac;
   }

   public void cmdRefresh(Object source) {
      //log it in the user console
      if (source instanceof PanelHelperKeyWalletSwitch) {
         PanelHelperKeyWalletSwitch panel = (PanelHelperKeyWalletSwitch) source;
         PublicKey pkNew = panel.getSelectedKeyPublicKey();
         if (pkNew != null) {
            psc.getLog().consoleLog("Selected key is now =" + pkNew.getName() + " " + pkNew.getBase58PubKey());
         } else {
            psc.getLog().consoleLog("Selected key is null");
         }
      }
   }

   protected PascAppCtx createCtx() {
      return new PascDemoCtx(psc, this);
   }

   /**
    * Called once inside the GUI thread.
    */
   protected CBentleyFrame createFrame() {
      frame = new CBentleyFrame(sc, "demo_panelhelper_keywalletswitch");
      //no key
      frame.setTitle("Demo of the PanelHelperKeyWalletSwitch");

      //we don't want auto lock
      pc.getPrefs().putBoolean(ITechPCore.PKEY_AUTO_LOCK, false);

      PanelTabLoginConsole panel = createLoginConsole();

      PrefIdable owner = new PrefIdable(sc, "panel");
      panelHelperKeyWalletNoW = new PanelHelperKeyWalletNoWildcards(psc, owner, this);
      panelHelperKeyWalletNoW.buildUI();

      JPanel center = new JPanel();
      center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
      center.add(Box.createRigidArea(new Dimension(0, 1)));
      center.add(panelHelperKeyWalletNoW);

      panel.setPanelCenter(center);
      //init the tab
      panel.initCheck();

      frame.getContentPane().add(panel);

      //set menubar
      MenuBarPascalDemo pascalMenuBarDemo = new MenuBarPascalDemo(psc, frame);
      frame.setJMenuBar(pascalMenuBarDemo);

      return frame;
   }

   public IMyTab createMainTab() {
      if (mainTab == null) {
         mainTab = new TabDemo(pdc, "demo_wildcard", this);
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
      PrefIdable owner = new PrefIdable(sc, "panel");
      panelHelperKeyWalletNoW = new PanelHelperKeyWalletNoWildcards(psc, owner, this);
      panelHelperKeyWalletNoW.buildUI();

      JPanel center = new JPanel();
      center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
      center.add(Box.createRigidArea(new Dimension(0, 1)));
      center.add(panelHelperKeyWalletNoW);

      tabDemo.add(center, BorderLayout.CENTER);
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, RunDemoKeyWalletWild.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, RunDemoKeyWalletWild.class);
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

      config.setFlagMaster(ITechConfig.MASTER_FLAG_08_OPEN_ALL_BUT_FALSE, true);
      //negatives
      config.setFlagTagNeg(ITechTags.FLAG_07_PRINT_EVENT, true);
   }

   //#enddebug

}
