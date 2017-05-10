
$(document).ready(function(){
                var bir = $("div#birinci").text();
                var iki = $("div#ikinci").text();
                var uc = $("div#ucuncu").text();
                var dort = $("div#dorduncu").text();
                var bes = $("div#besinci").text();
                var alti = $("div#altinci").text();
                var yedi = $("div#yedinci").text();
                var sekiz = $("div#sekizinci").text();
                var dokuz = $("div#dokuzuncu").text();
                var on = $("div#onuncu").text();
                var onbir = $("div#onbirinci").text();
                var oniki = $("div#onikinci").text();
                var onuc = $("div#onucuncu").text();
                var ondort = $("div#ondorduncu").text();
                    
                if(bir == "dolu"){
                    $("td#birincitd").removeClass("saatGorunum");
                    $("td#birincitd").addClass("tiklanmaz");
                }
                
                if(iki == "dolu"){
                    $("td#ikincitd").removeClass("saatGorunum");
                    $("td#ikincitd").addClass("tiklanmaz");
                }
                
                if(uc == "dolu"){
                    $("td#ucuncutd").removeClass("saatGorunum");
                    $("td#ucuncutd").addClass("tiklanmaz");
                    
                }
                
                if(dort == "dolu"){
                    $("td#dorduncutd").removeClass("saatGorunum");
                    $("td#dorduncutd").addClass("tiklanmaz");
                }
                
                if(bes == "dolu"){
                    $("td#besincitd").removeClass("saatGorunum");
                    $("td#besincitd").addClass("tiklanmaz");
                }
                
                if(alti == "dolu"){
                    $("td#altincitd").removeClass("saatGorunum");
                    $("td#altincitd").addClass("tiklanmaz");
                }
                
                if(yedi == "dolu"){
                    $("td#yedincitd").removeClass("saatGorunum");
                    $("td#yedincitd").addClass("tiklanmaz");
                }
                
                if(sekiz == "dolu"){
                    $("td#sekizincitd").removeClass("saatGorunum");
                    $("td#sekizincitd").addClass("tiklanmaz");
                }
                
                if(dokuz == "dolu"){
                    $("td#dokuzuncutd").removeClass("saatGorunum");
                    $("td#dokuzuncutd").addClass("tiklanmaz");
                }
                
                if(on == "dolu"){
                    $("td#onuncutd").removeClass("saatGorunum");
                    $("td#onuncutd").addClass("tiklanmaz");
                }
                
                if(onbir == "dolu"){
                    $("td#onbirincitd").removeClass("saatGorunum");
                    $("td#onbirincitd").addClass("tiklanmaz");
                }
                
                if(oniki == "dolu"){
                    $("td#onikincitd").removeClass("saatGorunum");
                    $("td#onikincitd").addClass("tiklanmaz");
                }
                
                if(onuc == "dolu"){
                    $("td#onucuncutd").removeClass("saatGorunum");
                    $("td#onucuncutd").addClass("tiklanmaz");
                }
                
                if(ondort == "dolu"){
                    $("td#ondorduncutd").removeClass("saatGorunum");
                    $("td#ondorduncutd").addClass("tiklanmaz");
                }
                
            });