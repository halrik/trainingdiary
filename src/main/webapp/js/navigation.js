var navigationHelper;

function NavigationHelper() {

	this.setSelectedPage = function(selectedPage) {
		var pageId = $(selectedPage).attr("id");
		$(selectedPage).find('div[data-role="navbar"] a[href*="' + pageId + '.html"]').addClass('ui-btn-active');
	};
};

$(document).ready( function() {
	navigationHelper = new NavigationHelper();

	$('div').live('pagebeforehide', function(event, ui) {
		navigationHelper.setSelectedPage(ui.nextPage);
	});
});