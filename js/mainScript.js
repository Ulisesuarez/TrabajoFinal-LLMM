let numPag=3;
let numNoticiasxPag=3;
let count= 0;
$(document).ready(function(){
    let page = getUrlParameter('page');
    let news = getUrlParameter('news');


    if(page>-1 && news>-1){

        $.getJSON( "data/"+page.toString()+".json", function( jsonObject ) {

            crearExpandida( 'paramlink' );

        });
        $('#addNewsbot').css({
            display:"none"
            })

    } else{
    $.getJSON( "data/0.json", function( jsonObject ) {
        cargar( jsonObject, false );

    });}

    $('#random').click(function () {
        $('#entrada').empty();
        crearExpandida('randomlink')
    });
    $('#addNewsbot').click(function(){
        if(count>2){
            console.log("WTF")
            $('#addNewsbot').css("display","none");
        }

        $.getJSON( "data/"+count+".json", function( jsonObject ) {
        cargar( jsonObject, true );

        });

    });

    function cargar(json ,button ){
    //let numeroNoticiasPorJson=3;

        $.each( json, function( i, noticia ) {
            if(news>-1&&page>-1&& !button){

                
                return true;
            }
            //$("section:last").append('<p>hola</p>');
            //$("section:last") .append( );
            let section =
            $( "<section/>", {
                "class": "noticiasSection"
            });
            let h3 =
                $( "<h3/>", {
                    "class": "ml-4 mb-3"
                });
            let a=
                $( "<a/>", {
                    cust:noticia.title,
                    href: "#",
                    text: noticia.title,
                    id:"link-"+count.toString()+i.toString()

            });

                    a.click(function(){
                        window.scrollTo(0, 0);
                        $('#entrada').empty();
                        crearExpandida(this);
                        //history.replaceState({},"",count.toString()+"/"+i.toString());
                    });
                    a.appendTo(h3);
                    h3.appendTo(section);



            let div1 =
                $( "<div/>", {
                    "class": "col-md-12"
                });

            let divImg =
                $( "<span/>", {
                    "class": "pull-left col-lg-4"
                });

            let img =
                $( "<img/>", {
                    "class": "noticiasImgSmall img-fluid mx-auto",
                    src: noticia.imgmid
                });
            img.appendTo(divImg);
            divImg.appendTo(div1);
            let divBody =
                $( "<span/>", {
                    "class": "pull-left col-lg-8"
                });
            divBody.appendTo(div1);
            let divDate =
                $( "<div/>", {
                    "class": "noticiasDate",
                    text: noticia.date
                });
            divDate.appendTo(divBody);
            $('<br>').appendTo(divBody);
            let divText =
                $( "<div/>", {
                    "class": "noticiasSummaryDiv ml-5"
                });

            let pText =
                $( "<p/>", {
                    "class": "noticiasSummary",
                    html: noticia.summary
                });
            let a2=
                $("<a/>", {
                    cust:noticia.title,
                    "class": "leerMas",
                    href: "#",
                    text: "Seguir leyendo...",
                    id:"slink-"+count.toString()+i.toString()

                });

            a2.click(function(){
                window.scrollTo(0, 0);
                $('#entrada').empty();
                crearExpandida(this);
                //history.replaceState({},"",count.toString()+"/"+i.toString());
            });

            pText.appendTo(divText);
            divText.appendTo(divBody);
            div1.appendTo(section);
            a2.appendTo(section);
            let spanVar = $("<span/>",{
                id: "social-mediaSect"}
        );
                let s1=
                    $("<a/>",{
                        href:"https://www.facebook.com/sharer/sharer.php?u=www.desinformacion.no",
                        "class":"facebook",
                        target: "_blank"
                    });
            let s2=
                $("<a/>",{
                    href:"https://twitter.com/intent/tweet",
                    "class":"twitter",
                    target: "_blank"
                });
            let s3=
                $("<a/>",{
                    href:"https://instagram.como",
                    "class":"instagram",
                    target: "_blank"
                });
            let s4=
                $("<a/>",{
                    href:"\"https://plus.google.com/share?url=",
                    "class":"googleplus",
                    target: "_blank"
                });
            s1.click(function(){
                modificarMeta(noticia,page,news)
            })
            s2.click(function(){
                modificarMeta(noticia,page,news)
            })
            s3.click(function(){
                modificarMeta(noticia,page,news)
            })
            s4.click(function(){
                modificarMeta(noticia,page,news)
            })
            s1.appendTo(spanVar);
            s2.appendTo(spanVar);
            s3.appendTo(spanVar);
            s4.appendTo(spanVar);

            spanVar.appendTo(section);
            
            if(count === 0){
                section.appendTo($('#inicial'))
            } else{
                section.insertAfter( $("section").last())
            }


        });

        count=count+1

    }
    let iner;
    $( window ).scroll(function() {
        if(count>2){
            console.log("WTF")
            $('#addNewsbot').css("display","none");
        }

        if ($(window).scrollTop() >= $(document).height() - $(window).height() - 10 && count!==iner) {
            let height = $(window).scrollTop();
            iner=count
            $.getJSON( "data/"+count+".json", function( jsonObject ) {
                cargar( jsonObject,false );

            });

            }

    });
    $.fn.followTo = function (pos) {
        let $this = this,
            $window = $(window);
        $window.scroll(function (e) {
            if ($window.scrollTop() < pos) {
                console.log('windowscrollTop<250');
                $this.css({
                    position: 'absolute',
                    top: pos,
                    marginTop:0
                });
            } else {
                $this.css({
                    position: 'fixed',
                    top: 0,
                    marginTop:0
                });
            }
            let docHeight = (document.height !== undefined) ? document.height : document.body.offsetHeight;

            if($window.scrollTop()>docHeight-650 && !($window.scrollTop() < pos)){
                    console.log('windowscrollTop>docHeight-650');
                    $this.css({
                        position: 'fixed',
                        marginTop:'-456px',
                        transition:'margin-top 3s'
                    });

            }
           })

    };

    $('#banner').followTo(300);
    let numJson;
    let numObject;
    let pagArray=[];
    let newsArray=[];



    for (i = 0; i < numPag; i++) {
        pagArray.push(i)

    }
    for (i = 0; i < numNoticiasxPag; i++) {
        newsArray.push(i)
    }


    function crearExpandida(link) {

        if(link ==='randomlink'){

            numJson = pagArray[Math.floor(Math.random() * pagArray.length)];
            numObject =  newsArray[Math.floor(Math.random() * newsArray.length)];
            console.log(numJson,numObject)
        }

        else if (link === 'paramlink') {
            numJson = page;
            numObject = news;

        } else {
            numJson = link.id.substr(link.id.length - 2, 1);
            numObject = link.id.substr(link.id.length - 1, 1);
        }


        $.getJSON("data/" + numJson + ".json", function (jsonObject) {
            let noticia = jsonObject[numObject];
            let section =
                $("<section/>", {
                    "class": "noticiasExpandedSection"
                });
            let h1 =
                $("<h1/>", {
                    "class": "mt-5 mb-3",
                    text: noticia.title
                });

            h1.appendTo(section);
            if (noticia.subtitle) {
                let h4 =
                    $("<h4/>", {
                        "class": "mb-3",
                        text: noticia.subtitle
                    });
                h4.appendTo(section);
            }
            let img =
                $("<img/>", {
                    "class": "noticiasImgBig img-fluid mx-auto",
                    src: noticia.imgbig
                });
            img.appendTo(section);

            let div1 =
                $("<div/>", {
                    "class": "mt-1 mb-3 ml-4"
                });

            let spanAuth =
                $("<span/>", {
                    "class": "spAuth",
                    text: noticia.author
                });
            let spanSpace =
                $("<span/>", {
                    text: " || "
                });
            let spanDate =
                $("<span/>", {
                    "class": "spDate",
                    text: noticia.date
                });
            spanAuth.appendTo(div1);
            spanSpace.appendTo(div1);
            spanDate.appendTo(div1);
            div1.appendTo(section);
            let divBody =
                $("<div/>", {
                    "class": "textExp mt-1 mb-1"

                });
            let p1 = $("<p/>", {
                html: noticia.text
            });
            p1.appendTo(divBody);
            if (noticia.video) {
                let divFrame =
                    $("<div/>", {
                        "class": "divvid embed-responsive embed-responsive-16by9 mx-auto"
                    });
                let iframe =
                    $("<iframe/>", {
                        "class": "embed-responsive-item",
                        src: noticia.video,
                        frameborder: "0",
                        allow: "autoplay; encrypted-media",
                        allowfullscreen: "true"
                    });
                iframe.appendTo(divFrame);
                divFrame.appendTo(divBody);
                $('<br>').appendTo(divBody);
            }
            if (noticia.text2) {
                let p2 =
                    $("<p/>", {
                        "class": "noticiasSummary",
                        html: noticia.text2
                    });
                p2.appendTo(divBody);
            }

            divBody.appendTo(section);
            let spanVar = $("<span/>",{
                id: "social-media2"}
            );
            let s1=
                $("<a/>",{
                    href:"https://www.facebook.com/sharer/sharer.php?u=https%3A//cdn.rawgit.com/Ulisesuarez/TrabajoFinal-LLMM/master/main.html?page="+numJson+"%26news="+numObject,
                    "class":"facebook",
                    target: "_blank"
                });
            let s2=
                $("<a/>",{
                    href:"https://twitter.com/home?status=https%3A//cdn.rawgit.com/Ulisesuarez/TrabajoFinal-LLMM/master/main.html?page="+numJson+"%26news="+numObject,
                    "class":"twitter",
                    target: "_blank"
                });
            let s3=
                $("<a/>",{
                    href:"https://instagram.com/share?url=https%3A//cdn.rawgit.com/Ulisesuarez/TrabajoFinal-LLMM/master/main.html?page"+numJson+"%26news="+numObject,
                    "class":"instagram",
                    target: "_blank"
                });
            let s4=
                $("<a/>",{
                    href:"\"https://plus.google.com/share?url=https%3A//cdn.rawgit.com/Ulisesuarez/TrabajoFinal-LLMM/master/main.html?page"+numJson+"%26news="+numObject,
                    "class":"googleplus",
                    target: "_blank"
                });
            s1.click(function(){
                modificarMeta(noticia,page,news)
            });
            s2.click(function(){
                modificarMeta(noticia,page,news)
            });
            s3.click(function(){
                modificarMeta(noticia,page,news)
            });
            s4.click(function(){
                modificarMeta(noticia,page,news)
            });
            s1.appendTo(spanVar);
            s2.appendTo(spanVar);
            s3.appendTo(spanVar);
            s4.appendTo(spanVar);

            spanVar.appendTo(section);

            section.appendTo($('#entrada'))

        })
    }


});


let getUrlParameter = function getUrlParameter(sParam) {
    let sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};

function modificarMeta(noticia, page, news) {
   $("meta[property='og:image']").setAttribute(("content", noticia.imgbig));
   $("meta[property='og:title']").setAttribute(("content", noticia.title));
   $("meta[property='og:url']").setAttribute(("content", "https://cdn.rawgit.com/Ulisesuarez/TrabajoFinal-LLMM/master/main.html?page="+page+"&news="+news));
   $("meta[property='og:description']").setAttribute(("content", noticia.summary));}

/*http://desinformacion.no/?page=0&news=0.

let page = getUrlParameter('page');
let new = getUrlParameter('news');


function getDocumentHeight() {
    const body = document.body;
    const html = document.documentElement;

    return Math.max(
        body.scrollHeight, body.offsetHeight,
        html.clientHeight, html.scrollHeight, html.offsetHeight
    );
}

function getScrollTop() {
    return (window.pageYOffset !== undefined) ? window.pageYOffset : (document.documentElement || document.body.parentNode || document.body).scrollTop;
}*/