$(function() {
    $("#stu_username_hide").focusout(
        function () {
            var number = $(this).val();
            if(number = '') {
                $(this).val('输入');
            }
        }
    );
})