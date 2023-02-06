package pasa.cbentley.jpasc.swing.demo.ctx;

import java.awt.Image;

import pasa.cbentley.jpasc.swing.demo.all.TabDemo;
import pasa.cbentley.swing.imytab.FrameReferenceTabAbstract;
import pasa.cbentley.swing.imytab.IMyTab;

public interface IPascDemo {

   public Image getLogo64();

   public IMyTab createMainTab();

   public void initTab(TabDemo tabDemo);

}
