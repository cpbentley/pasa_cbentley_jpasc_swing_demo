package pasa.cbentley.jpasc.swing.demo.all;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.swing.demo.ctx.IPascDemo;
import pasa.cbentley.jpasc.swing.demo.ctx.PascDemoCtx;
import pasa.cbentley.swing.ctx.SwingCtx;
import pasa.cbentley.swing.imytab.FrameIMyTab;
import pasa.cbentley.swing.imytab.FrameReference;
import pasa.cbentley.swing.imytab.FrameReferenceTabAbstract;
import pasa.cbentley.swing.imytab.IMyTab;

/**
 * A {@link FrameReference} that uses {@link FrameIMyTab} for the {@link IPascDemo}
 * 
 * @author Charles Bentley
 *
 */
public class FrameReferenceDemo extends FrameReferenceTabAbstract {

   private PascDemoCtx pdc;

   private IPascDemo   demo;

   public FrameReferenceDemo(PascDemoCtx pdc, IPascDemo demo) {
      super(pdc.getSwingCtx());
      this.pdc = pdc;
      this.demo = demo;
   }

   protected void customizeFrame(FrameIMyTab f) {

   }

   /**
    * Creates the {@link IMyTab} that will live inside the {@link FrameIMyTab}
    * @return
    */
   protected IMyTab createTab() {
      return demo.createMainTab();
   }
   
   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, FrameReferenceDemo.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, FrameReferenceDemo.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   

}
