package com.applause.auto.pageframework.locators;

public class Locators {
	
	public static final class HomePage {
		public final static String PAGE_LOGO = ("com.wholefoods.wholefoodsmarket:id/header_wfm_logo");
		public final static String SEARCH_BTN = ("com.wholefoods.wholefoodsmarket:id/imgSearch");
		public final static String SEARCH_FLD = ("com.wholefoods.wholefoodsmarket:id/etHomeSearch");
	}

	public static final class SearchPage {
		public final static String PAGE_TITLE = ("com.wholefoods.wholefoodsmarket:id/header_title");
		public final static String SEARCH_BTN = ("com.wholefoods.wholefoodsmarket:id/recipeFilterBtn");
		public final static String SEARCH_FLD = ("com.wholefoods.wholefoodsmarket:id/recipeSearchEditBox");
		public final static String LIST_OF_ITEMS = ("com.wholefoods.wholefoodsmarket:id/recipesSearchResultsGrid");
		public final static String LIST_OF_ITEMS_Xpath = ("//*[@resource-id='com.wholefoods.wholefoodsmarket:id/recipesSearchResultsGrid']/*[@class='android.widget.RelativeLayout']");
		public final static String FOUND_ITEM_TITLE = ("com.wholefoods.wholefoodsmarket:id/searchRecipesItemTitle");
		public final static String FOUND_ITEM_AMOUNT_OF_VOTED = ("com.wholefoods.wholefoodsmarket:id/recipesItemRatingText");
	}
}
