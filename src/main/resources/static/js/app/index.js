var index = {
    init: function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save: function () {
        var data = {
            name: $('#name').val(),
            price: $('#price').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/Foods',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });

    }
};
index.init()

var chair = {
    init: function () {
        var _this = this;
        $('#READY').on('click', function () {
            _this.ready();
        });
    },
    ready: function () {
        var data = {
            name: $('#READY').val("READY")
        };

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

chair.init();
