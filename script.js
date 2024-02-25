const formulario = document.querySelector("form");

const Icurso = document.querySelector(".curso")
const Idata = document.querySelector(".data")
const Icod_certificado = document.querySelector(".cod_certificado")
const Icod_certificado_instrutor = document.querySelector(".cod_certificado_instrutor")
const Inome_instrutor = document.querySelector(".nome_instrutor")
const Iescola_certificacao = document.querySelector(".escola_certificacao")
const Icertificadora = document.querySelector(".certificadora")


function cadastrar () {
    fetch("http://localhost:8080/mergulho",
    {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'

        },
        method: "POST",
        body: JSON.stringify ({
            curso: Icurso.value,
            data: Idata.value,
            cod_certificado: Icod_certificado.value,
            cod_certificado_instrutor: Icod_certificado_instrutor.value,
            nome_instrutor: Inome_instrutor.value,
            escola_certificacao: Iescola_certificacao.value,
            certificadora: Icertificadora.value
        })
    })
    .then(function (res) {console.log(res)})
    .catch(function (res) {console.log(res)})

};

function limpar () {
            Icurso.value = "";
            Idata.value = "";
            Icod_certificado.value = "";
            Icod_certificado_instrutor.value = "";
            Inome_instrutor.value  = "";
            Iescola_certificacao.value  = "";
            Icertificadora.value  = "";

};

formulario.addEventListener('submit', function(event) {
    event.preventDefault();

    cadastrar();
    limpar();
});