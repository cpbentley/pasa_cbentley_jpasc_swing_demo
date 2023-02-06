/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.swing.demo.all;

import javax.swing.JMenuBar;

import pasa.cbentley.jpasc.appswing.ctx.PascAppCtx;
import pasa.cbentley.jpasc.appswing.interfaces.IPascAppAbout;
import pasa.cbentley.jpasc.appswing.menu.MenuBarFactoryPascApp;
import pasa.cbentley.jpasc.appswing.menu.MenuBarPascalAbout;
import pasa.cbentley.jpasc.appswing.menu.MenuBarPascalDaemonHelp;
import pasa.cbentley.jpasc.appswing.menu.MenuBarPascalNoConnection;
import pasa.cbentley.jpasc.appswing.panel.TabsNoobGifs;
import pasa.cbentley.jpasc.appswing.panel.tab.TabConnecting;
import pasa.cbentley.jpasc.appswing.panel.tab.TabWaitForDaemon;
import pasa.cbentley.jpasc.swing.demo.ctx.PascDemoCtx;
import pasa.cbentley.jpasc.swing.menu.MenuBarPascalDemo;
import pasa.cbentley.swing.imytab.ITabMenuBarFactory;
import pasa.cbentley.swing.window.CBentleyFrame;

/**
 * Create a menu bar.
 * 
 * What if the panel is decided by the brander?
 * 
 * @author Charles Bentley
 *
 */
public class MenuBarFactoryPascDemo extends MenuBarFactoryPascApp implements ITabMenuBarFactory {

   protected final PascDemoCtx pdc;

   public MenuBarFactoryPascDemo(PascDemoCtx pdc) {
      super(pdc);
      this.pdc = pdc;
   }

   public JMenuBar getMenuBar(Object owner, CBentleyFrame frame) {
      if (owner instanceof IPascAppAbout) {
         //we want a menu bar for the about frame
         return new MenuBarPascalAbout(pdc, frame);
      } else if (owner instanceof TabConnecting) {
         return null;
      } else if (owner instanceof TabWaitForDaemon) {
         return new MenuBarPascalNoConnection(pdc, frame);
      } else if (owner instanceof TabsNoobGifs) {
         return new MenuBarPascalDaemonHelp(pdc, frame);
      } else {
         //the default menu
         return new MenuBarPascalDemo(pdc.getPascalSwingCtx(), frame);
      }
   }
}
