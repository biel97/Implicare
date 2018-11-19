function bt1() { 
    document.getElementById("bt1").style.background = "#f0ad4e";
    document.getElementById("bt2").style.background = "#ffffff";
    document.getElementById("bt1").style.color = "#ffffff";
    document.getElementById("bt2").style.color = "#f0ad4e";
    $("#conteudo-cadastro").load("formCadastroEmpresa.jspf");
    $("#bt1").attr("value", "1");
    $("#bt2").attr("value", "0");
}

function bt2() {
    document.getElementById("bt2").style.background = "#f0ad4e";
    document.getElementById("bt1").style.background = "#ffffff";
    document.getElementById("bt2").style.color = "#ffffff";
    document.getElementById("bt1").style.color = "#f0ad4e";
    $("#conteudo-cadastro").load("formCadastroCandidato.jspf");
    $("#bt1").attr("value", "0");
    $("#bt2").attr("value", "1");
}

function bt1Fun(){
    var valor = $("#bt1").attr("value");
    return valor;
}

function bt2Fun(){
    var valor = $("#bt2").attr("value");
    return valor;
}