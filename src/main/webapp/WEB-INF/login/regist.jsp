<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>注册</title>  
    <link rel="stylesheet" href="/css/pintuer.css">
    <link rel="stylesheet" href="/css/admin.css">
    <script src="JQuery/jquery.js"></script>
    </head>
<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">           
            </div>         
            <form action="" method="post">
                <div class="panel loginbox">
                    <div class="text-center margin-big padding-big-top"><h1>打印软件注册页面</h1></div>
                    <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="text" class="input input-big" name="name" placeholder="注册账号" id="user" />
                                <span class="icon icon-user margin-small"></span>
                                <div class='tips' id="exception1"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="password" class="input input-big" name="password" placeholder="注册密码" id="password" />
                                <span class="icon icon-key margin-small"></span>
                                <div class='tips' id="exception2"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="password" class="input input-big" name="password" placeholder="确认密码" id="pwd" />
                                <span class="icon icon-key margin-small"></span>
                                <div class="tips" id="exception3"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="text" class="input input-big" name="name" placeholder="邮箱" id="email" />
                                <span class="icon icon-envelope margin-small"></span>
                                <div class="tips" id="exception4"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="text" class="input input-big" name="name" placeholder="手机号" id="mobile" />
                                <span class="icon icon-leaf margin-small glyphicon glyphicon-phone"></span>
                                <div class="tips" id="exception5"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field">
                               <input type="text" class="input input-big" name="code" placeholder="填写短信验证码" id="check" />
                               <!-- <img src="images/passcode.jpg" alt="" width="100" height="32" class="" style="">   -->
                               <input type="button" class="button passcode text-big input-big" value="获取短信验证码" style="height:44px;cursor:pointer;width:150px;line-height:20px;" id="note">                       
                               <div class="tips" id="exception6"></div>
                            </div>
                        </div> 
                    </div>
                    <div style="padding:0 30px 30px;">
                        <input type="button" class="button button-block bg-main text-big input-big" value="注册" style="margin-bottom: 10px;" id="register">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="/util/jiml-utils.js"></script>
<script src="/wzy/sign.js"></script>
</body>
</html>