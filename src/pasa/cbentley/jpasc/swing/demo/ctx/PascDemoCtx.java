package pasa.cbentley.jpasc.swing.demo.ctx;

import java.awt.Image;

import pasa.cbentley.jpasc.appswing.cmd.PascAppCmd;
import pasa.cbentley.jpasc.appswing.ctx.PascAppCtx;
import pasa.cbentley.jpasc.appswing.frame.FramesApp;
import pasa.cbentley.jpasc.appswing.menu.MenuBarFactoryPascApp;
import pasa.cbentley.jpasc.appswing.panel.tab.TabMainAbstract;
import pasa.cbentley.jpasc.swing.ctx.PascalSwingCtx;
import pasa.cbentley.jpasc.swing.demo.all.FramesDemo;
import pasa.cbentley.jpasc.swing.demo.all.MenuBarFactoryPascDemo;
import pasa.cbentley.jpasc.swing.demo.all.PascDemoCmds;
import pasa.cbentley.jpasc.swing.panels.core.PanelCtxHelperAbstract;

public class PascDemoCtx extends PascAppCtx {

   public static final int        CTX_ID = 5005;

   private IPascDemo              demo;


   public PascDemoCtx(PascalSwingCtx psc, IPascDemo demo) {
      super(psc);
      this.demo = demo;
   }

   public int getCtxID() {
      return CTX_ID;
   }

   protected PascAppCmd createCmds() {
      return new PascDemoCmds(this);
   }

   protected FramesApp createFrames() {
      return new FramesDemo(this, demo);
   }

   protected MenuBarFactoryPascApp createMenuFactory() {
      return new MenuBarFactoryPascDemo(this);
   }

   protected TabMainAbstract createTabMain() {
      return null;
   }

   /**
    * 
    */
   public Image getLogo64() {
      return demo.getLogo64();
   }

   public PanelCtxHelperAbstract createPanelCtxHelper() {
      return null;
   }

}
