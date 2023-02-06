package pasa.cbentley.jpasc.swing.demo.all;

import pasa.cbentley.jpasc.appswing.ctx.PascAppCtx;
import pasa.cbentley.jpasc.appswing.frame.FrameReferenceAboutAbstract;
import pasa.cbentley.jpasc.appswing.frame.FramesApp;
import pasa.cbentley.jpasc.swing.demo.ctx.IPascDemo;
import pasa.cbentley.jpasc.swing.demo.ctx.PascDemoCtx;
import pasa.cbentley.swing.imytab.FrameReferenceTabAbstract;

public class FramesDemo extends FramesApp {

   private final PascDemoCtx pdc;

   private IPascDemo demo;

   public FramesDemo(PascDemoCtx pdc, IPascDemo demo) {
      super(pdc);
      this.pdc = pdc;
      this.demo = demo;
   }

   protected FrameReferenceAboutAbstract createFrameReferenceAbout(PascAppCtx pac) {
      return new FrameReferenceDemoAbout(pdc);
   }

   public FrameReferenceTabAbstract createFrameMainWindow() {
      return new FrameReferenceDemo(pdc, demo);
   }
}
