package com.fuze.argoqr;

import java.util.ArrayList;

public class Deck {

	ArrayList<Card> cards;
	public Card CurrentCard = null;

	public Deck() {
		cards = new ArrayList<Card>();
	}

	/** вывод размера */
	public int get_size() {
		return cards.size();
	}

	public void add(Card card) {
		cards.add(card);
	}

	/*
	 * public Card search_card(String qrtext, Context context, View layout) {
	 * CurrentCard = null; for (Card card : cards) { if
	 * (qrtext.equalsIgnoreCase(card.getId()) == true) { CurrentCard = card; } }
	 * 
	 * Intent intent = new Intent();//создаёт намерение intent.setClass(context,
	 * DeckDialog.class);//намерение запустить класс DeckDialog
	 * intent.putExtra(DeckDialog.TEXT, CurrentCard.getDescription());//передаём
	 * данные startActivityForResult(intent,
	 * ACTIVITY_SETTINGS_REQUEST);//стартуем это активити
	 * 
	 * 
	 * TextView text = (TextView) layout.findViewById(R.id.text);
	 * text.setText(CurrentCard.getDescription()); ImageView image = (ImageView)
	 * layout.findViewById(R.id.image); if
	 * (CurrentCard.getType().equalsIgnoreCase("0") == true) {
	 * layout.setBackgroundColor(Color.RED); } else if
	 * (CurrentCard.getType().equalsIgnoreCase("1") == true) {
	 * layout.setBackgroundColor(Color.BLUE); } else if
	 * (CurrentCard.getType().equalsIgnoreCase("2") == true) {
	 * layout.setBackgroundColor(Color.GREEN); }
	 * image.setImageResource(R.drawable.card01 + CurrentCard.getNumer());
	 * 
	 * AlertDialog.Builder builder = new AlertDialog.Builder(context);
	 * builder.setView(layout); builder.setMessage(CurrentCard.getName() + " ("
	 * + CurrentCard.getRequirements() + ")");
	 * 
	 * builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	 * public void onClick(DialogInterface dialog, int id) { dialog.cancel();//
	 * QArgoActivity.this.finish(); } });
	 * 
	 * builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
	 * public void onClick(DialogInterface dialog, int id) { CurrentCard = null;
	 * dialog.cancel(); } });
	 * 
	 * builder.setCancelable(true); builder.create(); AlertDialog alert =
	 * builder.create(); alert.show();
	 * 
	 * 
	 * return CurrentCard; }
	 */

	public Card search_card(String qrtext) {
		CurrentCard = null;
		for (Card card : cards) {
			if (qrtext.equalsIgnoreCase(card.getId()) == true) {
				CurrentCard = card;
			}
		}

		return CurrentCard;
	}

}
