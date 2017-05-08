package org.test;

import com.vaadin.annotations.HtmlImport;
import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;
import org.vaadin.elements.Element;
import org.vaadin.elements.Elements;
import org.vaadin.elements.Tag;

/**
 * @author Alejandro Duarte
 */
@Tag("game-card")
public interface GameCard extends Element {
	static GameCard create() {
		return Elements.create(GameCard.class);
	}

	static GameCard create(String symbol, String rank) {
		GameCard gameCard = create();
		gameCard.setAttribute("symbol", symbol);
		gameCard.setAttribute("rank", rank);
		return gameCard;
	}

}
