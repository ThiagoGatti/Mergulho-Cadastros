const formulario = document.querySelector("form");

const icurso = document.querySelector(".curso")
const idata = document.querySelector(".data")
const icodigo_certificado = document.querySelector(".codigo_certificado")
const icodigo_certificado_instrutor = document.querySelector(".codigo_certificado_instrutor")
const inome_instrutor = document.querySelector(".nome_instrutor")
const iescola_certificacao = document.querySelector(".escola")
const icertificadora = document.querySelector(".certificadora")


function cadastrar () {

  console.log(JSON.stringify({
    curso: icurso.value,
            data: idata.value,
            Codigo_Certificado: icodigo_certificado.value,
            Codigo_Certificado_Instrutor: icodigo_certificado_instrutor.value,
            Nome_Instrutor: inome_instrutor.value,
            Escola: iescola_certificacao.value,
            certificadora: icertificadora.value
}))

    fetch("http://localhost:8080/mergulho",
    {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'

        },
        method: "POST",
        body: JSON.stringify ({
            curso: icurso.value,
            data: idata.value,
            codigo_Certificado: icodigo_certificado.value,
            codigo_Certificado_Instrutor: icodigo_certificado_instrutor.value,
            nome_Instrutor: inome_instrutor.value,
            escola: iescola_certificacao.value,
            certificadora: icertificadora.value
        })
    })
    .then(function (res) {console.log(res)})
    .catch(function (res) {console.log(res)})

};

function limpar () {
            icurso.value = "";
            idata.value = "";
            icodigo_certificado.value = "";
            icodigo_certificado_instrutor.value = "";
            inome_instrutor.value  = "";
            iescola_certificacao.value  = "";
            icertificadora.value  = "";

};

formulario.addEventListener('submit', function(event) {
    event.preventDefault();

    cadastrar();
    limpar();
});