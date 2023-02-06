package pasa.cbentley.jpasc.swing.demo.all;

import pasa.cbentley.jpasc.appswing.cmd.PascAppCmd;
import pasa.cbentley.jpasc.swing.demo.ctx.PascDemoCtx;

public class PascDemoCmds extends PascAppCmd {

   private final PascDemoCtx pdc;

   public PascDemoCmds(PascDemoCtx pdc) {
      super(pdc);
      this.pdc = pdc;
   }

}
