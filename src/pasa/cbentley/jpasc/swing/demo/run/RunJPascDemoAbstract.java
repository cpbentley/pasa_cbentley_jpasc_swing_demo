/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.swing.demo.run;

import java.util.List;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.interfaces.IPrefs;
import pasa.cbentley.core.src4.logging.BaseDLogger;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLogConfig;
import pasa.cbentley.core.src4.logging.ITechConfig;
import pasa.cbentley.core.src4.logging.ITechLvl;
import pasa.cbentley.core.src4.logging.ITechTags;
import pasa.cbentley.jpasc.appswing.run.RunPascAppAbstract;
import pasa.cbentley.jpasc.jsonrpc.ctx.JPascJsonRpcCtx;
import pasa.cbentley.jpasc.jsonrpc.engine.JPascJsonRPCClientFactory;
import pasa.cbentley.jpasc.pcore.ctx.IPascalCoinClientFactory;
import pasa.cbentley.jpasc.swing.demo.ctx.IPascDemo;
import pasa.cbentley.swing.actions.IExitable;

public abstract class RunJPascDemoAbstract extends RunPascAppAbstract implements IExitable, IPascDemo {


   /**
    * Super constructor initializes all the contexts
    */
   public RunJPascDemoAbstract() {
      super();
      
   }
   
   protected void startPreUI() {
      //we decide here what to use for RPC lib
      JPascJsonRpcCtx jjc = new JPascJsonRpcCtx(pc);
      IPascalCoinClientFactory fac = new JPascJsonRPCClientFactory(jjc);
      psc.getPCtx().setPascalCoinClientFactory(fac);
   }


   protected void addI18nPascalApp(List<String> list) {
      list.add("i18nPascalSwingDemo");
   }

   protected void initForPrefsPascal(IPrefs prefs) {

   }


   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, RunJPascDemoAbstract.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, RunJPascDemoAbstract.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
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
