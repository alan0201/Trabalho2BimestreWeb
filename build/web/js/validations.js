
function validaString(valor, minimo){
//    if(typeof valor === 'string' && valor.length >= minimo){
//        return true;
//    }
//    return false;
    
    return typeof valor === 'string' && valor.length >= minimo;
}


function validaNumber(valor, minimo, maximo){
    var valorNumerico = Number(valor);
    return typeof valorNumerico === 'number' && valorNumerico >= minimo && valorNumerico <= maximo  ;
}

function validaData(valor, minimo, maximo){
    var data = moment(valor, 'YYYY-MM-DD', true);
    
    return data.isValid() && data.isSameOrBefore(maximo) && data.isSameOrAfter(minimo) ;
}
function validaDataAno(valor, maximo){
    var data = moment(valor, 'YYYY', true);
    
    return data.isValid() && data.isSameOrBefore(maximo);
}
function validaComboboxEImagem(valor){
    
    return  valor !== null && valor.length > 0 ;
}
function validaCombustivel(combustivel){
    
    //console.log(combustivel);
    var array_combustivel = ["GASOLINA","ETANOL","FLEX","GAS","DIESEL"];
    
    if(array_combustivel.indexOf(combustivel) === -1){
        return false;
    }else{
        return true;
    }
    
}
function validaCategoria(categoria){
    
    //console.log(categoria);
    var array_categoria = ["1","2","3","4","5"];
    
    if(array_categoria.indexOf(categoria) === -1){
        return false;
    }else{
        return true;
    }
    
}
function validaEmail(email) {
    var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    if (!filter.test(email)) {
        return false;
    } else { 
        return true;
    }
}


