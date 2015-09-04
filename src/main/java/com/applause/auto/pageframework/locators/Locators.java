package com.applause.auto.pageframework.locators;

import org.openqa.selenium.By;

public class Locators {
	
	public static final class HomePage {
		public final static By PAGE_LOGO = By
				.id("com.wholefoods.wholefoodsmarket:id/header_wfm_logo");
		public final static By SEARCH_BTN = By
				.id("com.wholefoods.wholefoodsmarket:id/imgSearch");
		public final static By SEARCH_FLD = By
				.id("com.wholefoods.wholefoodsmarket:id/etHomeSearch");
	}

	public static final class SearchPage {
		public final static By PAGE_TITLE = By
				.id("com.wholefoods.wholefoodsmarket:id/header_title");
		public final static By SEARCH_BTN = By
				.id("com.wholefoods.wholefoodsmarket:id/recipeFilterBtn");
		public final static By SEARCH_FLD = By
				.id("com.wholefoods.wholefoodsmarket:id/recipeSearchEditBox");
		public final static By LIST_OF_ITEMS = By
				.xpath("//*[@resource-id='com.wholefoods.wholefoodsmarket:id/recipesSearchResultsGrid']/*[@class='android.widget.RelativeLayout']");
		public final static By FOUND_ITEM_TITLE = By
				.id("com.wholefoods.wholefoodsmarket:id/searchRecipesItemTitle");
		public final static By FOUND_ITEM_AMOUNT_OF_VOTED = By
				.id("com.wholefoods.wholefoodsmarket:id/recipesItemRatingText");
	}
}
