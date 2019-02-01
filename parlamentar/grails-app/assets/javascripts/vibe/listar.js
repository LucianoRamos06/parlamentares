$(document).ready(function () {
    $('.bt1').click(function() {
     $.blockUI({ message: '<h1><img src=\"https://img3.ibxk.com.br/2014/3/materias/4805475817181134.gif\" /> Carregando...</h1>'} );
        var url = $(this).data('url');
        console.log(url);
        $.ajax({
            'url' : url,
            'type' : 'GET'
    }).done(function (data) {
            $("#divModal").append(data);
            $('#exampleModal').modal('show');
        }).fail(function (jqXHR, textStatus) {
            console.log(textStatus)
        }).always(function() {
            $.unblockUI()
        });
    });
});