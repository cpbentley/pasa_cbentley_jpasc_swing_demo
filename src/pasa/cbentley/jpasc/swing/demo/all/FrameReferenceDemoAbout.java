package pasa.cbentley.jpasc.swing.demo.all;

import pasa.cbentley.jpasc.appswing.frame.FrameReferenceAboutAbstract;
import pasa.cbentley.jpasc.swing.demo.ctx.PascDemoCtx;
import pasa.cbentley.swing.imytab.IMyTab;

public class FrameReferenceDemoAbout extends FrameReferenceAboutAbstract {

   protected final PascDemoCtx pdc;

   public FrameReferenceDemoAbout(PascDemoCtx ptc) {
      super(ptc);
      this.pdc = ptc;
      
   }

   protected IMyTab createTab() {
      return new TabTabsDemoAbout(pdc);
   }
}
