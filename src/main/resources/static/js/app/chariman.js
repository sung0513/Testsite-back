var chairman = {
    init: function () {
        var _this = this;
        $('#READY').on('click', function () {
            _this.ready();
        });
    },
    ready: function () {
        var data = {
            status:null
    };
        $('#READY').on('click', function () {
            data.status="READY"
        });

        $.ajax({
            type: 'POST',
            url: '/api/v1/delivery',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('배달상태 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

chairman.init();