(function ($) {
  var $form = $("#estimateForm");
  $("#estimateForm").on('submit', function(e) {
    e.preventDefault();
    $.ajax({
      url: $form.attr('action'),
      type: 'post',
      data: $form.serialize(),
      success: function(response) {
        // if the response contains any errors, replace the form
        if ($(response).find('.has-error').length) {
          $form.replaceWith(response);
        } else {
        	$("#estimate-price").html(response)
          // in this case we can actually replace the form
          // with the response as well, unless we want to
          // show the success message a different way
        }
      }
  });
})})(jQuery);