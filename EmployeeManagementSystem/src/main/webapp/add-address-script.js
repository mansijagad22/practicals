$(document).ready(function(){
	$("#addNewAddress").click(function(e){
			e.preventdefault();
			
			var street = jQuery('<div>',{
				'class':'form-group col sm-6'
			}).append(jQuery('<input>',{
				'name':'street',
				'id':'street',
				'placeholder':'street',
				'class':'form-control',
				'type':'text'
			}));

			var city = jQuery('<div>',{
				'class':'form-group col sm-6'
			}).append(jQuery('<input>',{
				'name':'city',
				'id':'city',
				'placeholder':'city',
				'class':'form-control',
				'type':'text'
			}));
			
			var state = jQuery('<div>',{
				'class':'form-group col sm-6'
			}).append(jQuery('<input>',{
				'name':'state',
				'id':'state',
				'placeholder':'state',
				'class':'form-control',
				'type':'text'
			}));
			
				var pincode = jQuery('<div>',{
					'class':'form-group col sm-6'
			}).append(jQuery('<input>',{
				'name':'pincode',
				'id':'pincode',
				'placeholder':'pincode',
				'class':'form-control',
				'type':'text'
			}));
			
			$("#saveaddress").append(street);
			$("#saveaddress").append(city);
			$("#saveaddress").append(state);
			$("#saveaddress").append(pincode);
						
		});
});

