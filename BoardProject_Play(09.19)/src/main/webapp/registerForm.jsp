<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table {
  border-collapse: separate;
  border-spacing: 0 10px;
}
</style>
<body>
<h2>회원 가입 창</h2>
<table>
<tr><td>아이디 : <input type="text" id="registerId"></td>
<td><input type="button" id="findDouble" name="findDouble" onclick="return idCheck()" value="중복체크"></tr>
<tr><td colspan=3 id="idDoubleCheck" style="color:red"></tr> <!-- 중복여부 확인 -->
<tr><td>이름 : <input type="text" id="registerName"></td>
<tr><td>패스워드: <input type="password" id="registerPw"></td></tr>
<tr><td>패스워드 확인: <input type="password" id="passwordCheck"></td></tr>
<tr><td><input type="button" id="btnRegister" name="btnRegister" onclick="return register()" value="회원 가입 등록">
</table>
</body>
<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
<Script>

function idCheck(){ 
	$.ajax({
		url: "findId",
		type: "POST",
		cache: true,
		dataType: "json",
		data: {
			mid : $("#registerId").val()
		},
		success: 	
			function(data){	
			console.log(data);
			if(data['memberId']==""){
				alert('ID를 입력하세요.');
				$("#btnRegister").prop('disabled', true);
				$("#idDoubleCheck").html('아이디를 입력해주세요.');
			}
			else if(data['result'] == 1){
				alert('이미 '+data['memberId'] +'이 존재합니다.');
				$("#btnRegister").prop('disabled', true);
				$("#idDoubleCheck").html('아이디 중복');
				
			}else{
				alert(data['memberId']+'으로 가입하셔도 됩니다.')
				 $("#btnRegister").removeAttr("disabled");
			}
		},
		error:
			function (request,status,error) {
				alert("ajax실패");
			}
	})
}

function register() {
	$.ajax({
		url: "newRegister",
		type: "POST",
		cache: true,
		dataType: "json",
		data: {
			mid:$("#registerId").val(),
			mpassword:$("#registerPw").val(),
			checkpassword:$("#passwordCheck").val(),
			mname:$("#registerName").val()
		},
		success: 
			function (data) {
			console.log(data);
			alert("정상적으로 가입되었습니다.");
		},
		error:
			function (request,status,error) {
				alert('다시 작성해주세요.')
			}
	})
}

</Script>
</html>