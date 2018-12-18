/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.gui.login;

import java.util.Observable;

/**
 * The <code>ObservableMenu</code> abstract class used to implement <b>Observer
 * Pattern</b> with anonymous inner class.
 * <p>
 * <b>Observable</b>: @{@link ObservableMenu}.
 * <b>Observer</b>: @{@link dz.ummto.ansejnextgen.template.Menu#menuJpanel}.
 * 
 * @see <a href=
 *      "https://blog.xebia.fr/2012/11/08/back-to-basics-bien-maitriser-les-classes-internes-en-java/">link</a>
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
abstract class ObservableMenu extends Observable {

	abstract void changeMenu();

}
