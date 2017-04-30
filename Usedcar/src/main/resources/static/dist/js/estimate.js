(function($) {

	var $form = $("#estimateForm");

	$("#brand").on('change mouseup', function(e) {
		e.preventDefault();
		$.ajax({
			url : $form.attr('action') + '/getModel',
			type : 'post',
			data : $form.serialize(),
			success : function(response) {
				// if the response contains any errors, replace the form
				if ($(response).find('.has-error').length) {
					$form.replaceWith(response);
				} else {
					$("#estimate-model").html(response);
					$("#estimate-submodel").html('');
					$("#estimate-year").html('');
					$("#estimate-check").html('');
					$("#estimate-price").html('');
					// in this case we can actually replace the form
					// with the response as well, unless we want to
					// show the success message a different way
				}
			}
		});
		
	});

	$("#estimate-model").on('change mouseup', function(e) {
		e.preventDefault();
		$.ajax({
			url : $form.attr('action') + '/getSubModel',
			type : 'post',
			data : $form.serialize(),
			success : function(response) {
				// if the response contains any errors, replace the form
				if ($(response).find('.has-error').length) {
					$form.replaceWith(response);
				} else {
					$("#estimate-submodel").html(response);
					$("#estimate-year").html('');
					$("#estimate-check").html('');
					$("#estimate-price").html('');
					// in this case we can actually replace the form
					// with the response as well, unless we want to
					// show the success message a different way
				}
			}
		});
	});
	
	$("#estimate-submodel").on('change mouseup', function(e) {
		e.preventDefault();
		$.ajax({
			url : $form.attr('action') + '/getYear',
			type : 'post',
			data : $form.serialize(),
			success : function(response) {
				// if the response contains any errors, replace the form
				if ($(response).find('.has-error').length) {
					$form.replaceWith(response);
				} else {
					$("#estimate-year").html(response);
					$("#estimate-check").html('');
					$("#estimate-price").html('');
					// in this case we can actually replace the form
					// with the response as well, unless we want to
					// show the success message a different way
				}
			}
		});
	});

	$("#estimate-year").on('change mouseup', function(e) {
		e.preventDefault();
		$.ajax({
			url : $form.attr('action')+'/getCheckList',
			type : 'post',
			data : $form.serialize(),
			success : function(response) {
				// if the response contains any errors, replace the form
				if ($(response).find('.has-error').length) {
					$form.replaceWith(response);
				} else {
					$("#estimate-check").html(response);
					$("#estimate-price").html('');
					// in this case we can actually replace the form
					// with the response as well, unless we want to
					// show the success message a different way
				}
			}
		});
	});

	$("#estimateForm").on('submit', function(e) {
		e.preventDefault();
		$.ajax({
			url : $form.attr('action'),
			type : 'post',
			data : $form.serialize(),
			success : function(response) {
				// if the response contains any errors, replace the form
				if ($(response).find('.has-error').length) {
					$form.replaceWith(response);
				} else {
					$("#estimate-price").html(response);
					// in this case we can actually replace the form
					// with the response as well, unless we want to
					// show the success message a different way
				}
			}
		});
	});
})(jQuery);