/*!
* Start Bootstrap - Simple Sidebar v6.0.6 (https://startbootstrap.com/template/simple-sidebar)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-simple-sidebar/blob/master/LICENSE)
*/
// 
// Scripts
// 

window.addEventListener('DOMContentLoaded', event => {

    // Toggle the side navigation
    const sidebarToggle = document.body.querySelector('#sidebarToggle');
    if (sidebarToggle) {
        // Uncomment Below to persist sidebar toggle between refreshes
        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     document.body.classList.toggle('sb-sidenav-toggled');
        // }
        sidebarToggle.addEventListener('click', event => {
            event.preventDefault();
            document.body.classList.toggle('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
        });
    }

});

// API Script.

const cepBotao = document.getElementById("cepBotao");
const cepTexto = document.getElementById("cepTexto");;
const resultado = document.querySelector("#resultado");;

cepBotao.addEventListener("click", () => {
	
	const cep = cepTexto.value;
	const url = "/viacep/" + cep;

	fetch(url)
		.then(response => response.json())
		.then(json => {
			
			jsonString = JSON.stringify(json);
			console.log(jsonString)
			
			jsonString = jsonString.replace(/"|{|}/gi, "");
			console.log(jsonString)
			const array = jsonString.split(",");
			console.log(array)
			let result = "<br />"; // If value is undefined, it will therefore print "undefined".
			
			for (let i = 0; i < array.length; i++) {
				
				currentField = array[i].split(":");
				
				result += `${currentField[0]}: ${currentField[1]}<br />`
				
			}
			
			resultado.innerHTML = result;
			
		})
		.catch(erro => console.error("Erro:", erro));
	
});