package com.fuze.argoqr;

import android.content.res.XmlResourceParser;
import android.util.Log;

/** парсер колоды из xml */
public class ParserDeck {
	Deck deck;

	XmlResourceParser parser;

	ParserDeck(XmlResourceParser parser) {
		this.parser = parser;

	}

	/** распарсить */
	public Deck parse() {
		try {
			int eventType = parser.getEventType();
			Card currentcard = null;
			boolean done = false;
			int num = 0;

			while (eventType != XmlResourceParser.END_DOCUMENT && !done) {
				String name = null;
				switch (eventType) {
				case XmlResourceParser.START_DOCUMENT:
					break;
				case XmlResourceParser.START_TAG:
					name = parser.getName();
					if (name.equalsIgnoreCase("Deck")) {
						deck = new Deck();
					} else if (deck != null && name.equalsIgnoreCase("Card")) {
						currentcard = new Card(parser.getAttributeValue(0), num);
						num++;
						deck.add(currentcard);

					} else if (currentcard != null) {
						if (name.equalsIgnoreCase("Name")) {
							currentcard.setName(parser.getAttributeValue(0));
						} else if (name.equalsIgnoreCase("Picture")) {
							currentcard.setPicture(parser.getAttributeValue(0));
						} else if (name.equalsIgnoreCase("Description")) {
							currentcard.setDescription(parser
									.getAttributeValue(0));
						} else if (name.equalsIgnoreCase("Type")) {
							currentcard.setType(parser.getAttributeIntValue(
									null, "value", 0));
						} else if (name.equalsIgnoreCase("Requirements")) {
							currentcard.setRequirements(parser
									.getAttributeIntValue(null, "value", 0));
						} else if (name.equalsIgnoreCase("PlayerChanges")) {
							currentcard.setPlayerChanges_beasts(parser
									.getAttributeIntValue(null, "beasts", 0));
							currentcard.setPlayerChanges_bricks(parser
									.getAttributeIntValue(null, "bricks", 0));
							currentcard.setPlayerChanges_gems(parser
									.getAttributeIntValue(null, "gems", 0));
							currentcard.setPlayerChanges_tower(parser
									.getAttributeIntValue(null, "tower", 0));
							currentcard.setPlayerChanges_wall(parser
									.getAttributeIntValue(null, "wall", 0));

						} else if (name.equalsIgnoreCase("EnemyChanges")) {
							currentcard.setEnemyChanges_beasts(parser
									.getAttributeIntValue(null, "beasts", 0));
							currentcard.setEnemyChanges_bricks(parser
									.getAttributeIntValue(null, "bricks", 0));
							currentcard.setEnemyChanges_gems(parser
									.getAttributeIntValue(null, "gems", 0));
							currentcard.setEnemyChanges_tower(parser
									.getAttributeIntValue(null, "tower", 0));
							currentcard.setEnemyChanges_wall(parser
									.getAttributeIntValue(null, "wall", 0));

						} else if (name.equalsIgnoreCase("PlayerMod")) {
							currentcard.setPlayerMod_beasts(parser
									.getAttributeIntValue(null, "beasts", 0));
							currentcard.setPlayerMod_bricks(parser
									.getAttributeIntValue(null, "bricks", 0));
							currentcard.setPlayerMod_gems(parser
									.getAttributeIntValue(null, "gems", 0));

						} else if (name.equalsIgnoreCase("EnemyMod")) {
							currentcard.setEnemyMod_beasts(parser
									.getAttributeIntValue(null, "beasts", 0));
							currentcard.setEnemyMod_bricks(parser
									.getAttributeIntValue(null, "bricks", 0));
							currentcard.setEnemyMod_gems(parser
									.getAttributeIntValue(null, "gems", 0));

						} else if (name.equalsIgnoreCase("Damage")) {
							currentcard.setDamage_enemy(parser
									.getAttributeIntValue(null, "enemy", 0));
							currentcard.setDamage_self(parser
									.getAttributeIntValue(null, "self", 0));

						} else if (name.equalsIgnoreCase("AdditionalTurn")) {
							currentcard.setTurn(parser.getAttributeIntValue(
									null, "value", 0));

						} else if (name.equalsIgnoreCase("Script")) {
							currentcard.setScript(parser.getAttributeIntValue(
									null, "value", 0));

						} else if (name.equalsIgnoreCase("DiscardCard")) {
							currentcard.setDiscardCard(parser
									.getAttributeIntValue(null, "value", 0));
						}
					}

					break;

				case XmlResourceParser.END_TAG:
					name = parser.getName();
					if (name.equalsIgnoreCase("Deck")) {
						done = true;
					}
					break;
				}
				eventType = parser.next();

			}

			parser.close();

		} catch (Exception e) {
			Log.e("qargo", e.getMessage());
			// TODO
		}
		return deck;
	}

}
