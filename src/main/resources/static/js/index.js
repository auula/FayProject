/**
 *  @about: ding coding1618@gmail.com
 * create time : 2018-12-19 21:19:14
 */
var domain = "http://" + window.location.host;

var EmailReg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

var PwdReg = /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!.@#$%^&*? ]).*$/;

// getCaptcha
$(".code").click(function () {
    var url = domain + "/" + new Date().getTime() + "/captcha";
    $(".code").attr("src", url)
});

//print logo
figlet("Fay Beta 1.8", 'Standard', function (err, text) {
    if (err) {
        console.log('系统故障~请截图联系管理员Email:coding1618@gmail.com');
        console.dir(err);
        return;
    }
    console.log(text);
});
if (window.console && window.console.log) {
    console.log("%c Fay (beta v1.8) %c https://fay.codegc.me Email:coding1618@gmail.com ","color: #fff; margin: 1em 0; padding: 5px 0; background: #673ab7;","margin: 1em 0; padding: 5px 0; background: #efefef;");
}

function validate() {

    if (!EmailReg.test($("#defaultLoginFormEmail").val())) {
        $("#mess").html("邮箱格式不正确！！");
        return;
    }

    // if (!PwdReg.test($("#defaultLoginFormPassword").val())) {
    //     $("#mess").html("密码最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符！！");
    //     return;
    // }

    if ($("#defaultLoginFormText").val().length < 4) {
        $("#mess").html("验证码不正确！！");
        return;
    }

    $("#mess").css("color","#0054ff").html("正在登录....");
    sendLoginData();
}

function sendLoginData() {
    $.ajax({
        url: domain + "/" + new Date().getTime() + "/user/login",
        type: "post",
        cache: false,
        async: false,
        dataType: "json",
        data: {
            "email": $("#defaultLoginFormEmail").val(),
            "password": $("#defaultLoginFormPassword").val(),
            "code": $("#defaultLoginFormText").val()
        },
        success: function (result) {
            console.log(result.status);
            if (result.status != "200") {
                $("#mess").css("color", "red").html(result.messages);
            } else {
                window.location.href = domain + "/system/main";
            }
        }
    });

}