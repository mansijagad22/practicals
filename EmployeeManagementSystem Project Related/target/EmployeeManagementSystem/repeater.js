jQuery.fn.extend({

    createRepeater: function () {

        var generateId = function (string) {

            return string

                .replace(/\[/g, '_')

                .replace(/\]/g, '')

                .toLowerCase();

        };

 

        var addItem = function (items, key, fresh = true) {

            var newEle=items.clone();

            var itemContent = newEle;

            var group = itemContent.data("group");

            var item = itemContent;

            var input = item.find('input,select,textarea');

 

            input.each(function (index, el) {

                var attrName = $(el).data('name');

                var skipName = $(el).data('skip-name');

                if (skipName != true) {

                    $(el).attr("name", group + "[" + key + "]" + "[" + attrName + "]");

                } else {

                    if (attrName != 'undefined') {

                        $(el).attr("name", attrName);

                    }

                }

                $(el).attr('value', '');

               

 

                $(el).attr('id', generateId($(el).attr('name')));

                $(el).parent().find('label').attr('for', generateId($(el).attr('name')));

            })

 

            var itemClone = newEle;

 

            /* Handling remove btn */

            var removeButton = itemClone.find('.remove-btn');
            removeButton.attr("value","Remove");
            if (key == 0) {
                removeButton.attr('disabled', true);
            } else {
                removeButton.attr('disabled', false);
            }

            removeButton.attr('onclick',"$(this).parents('.items').remove()");

           

            var newItem = $("<div class='items'>" + itemClone.html() + "<div/>");

            newItem.attr('data-index',this.key)

 

            repeater.append(newItem);

        };

 

        /* find elements */

        var repeater = this;

        var items = $("body").find(".items");

        var key = items.length+1;

        var addButton = repeater.find('.repeater-add-btn');

 

        var removeButton = repeater.find('.remove-btn');

       

        removeButton.attr('onclick',"$(this).parents('.items').remove()");
        
           /* handle click and add items */

        addButton.on("click", function () {

            addItem($(items[0]), key);

            key++;

        });

    }

});

 