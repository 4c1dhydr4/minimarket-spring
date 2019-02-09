<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style type="text/css">
                html{
                        font-family: Courier;
                }
                h4{
                        line-height: 0;
                        margin: 0px;
                        border: 0px;
                        padding: 0px;
                }
                span{
                        display: inline;
                        font-weight: bolder;
                        line-height: 1em;
                }
                .spanClss{
                        font-weight: bolder;
                        line-height: 1em;
                }
                .centertick{
                        text-align: center;
                        display: inline-grid;
                        position: relative;
                        width: 300px;
                }
                .centertick1{
                        text-align: center;
                        display: inline-grid;
                        position: relative;
                        width: 300px;
                        height: 100px;
                }
                .centertick2{
                        text-align: left;
                        display: inline-grid;
                        position: relative;
                        width: 300px;
                        height: 100px;
                }
                .centertick2 h4{
                        line-height: 1 !important;
                }
                .total{
                        line-height: 2em;
                        text-align: right;
                        margin: 0px;
                        border: 0px;
                        padding: 0px;
                }
                .total_char{
                        line-height: 2em;
                        font-weight: bolder;
                        text-align: left;
                        margin: 0px;
                        border: 0px;
                        padding: 0px;
                }
                .left_just{
                        text-align: left !important;
                }
                .text_red{
                        color: red;
                }
                .text_blue{
                        color: blue;
                }
        </style>
    </head>
    <body>
        <div>
            <div class="centertick1">
                <h4>Minimarket Doña Paty</h4>
                <h4>Universidad Privada del Norte</h4>
                <h4>RUC: 976880089</h4>
                <h4>Cajero: </h4><strong>${Ticket.getSalesMan()}</strong>
            </div>
        </div>
        <div>
            <div class="centertick">
                <table id="tabla_comida">
                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Descripción</th>
                            <th>P.Uni</th>
                            <th>Cantidad</th>
                            <th>Importe</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${TicketDetail}" var="det">
                            <tr>
                                <td><span>${det.getProductCode()}</span></td>
                                <td class="left_just"><span>${det.getProductName()}</span></td>
                                <td><span>${det.getUnitPrice()}0</span></td>
                                <td>${det.getDetailQuantity()}</td>
                                <td class="spanClss">${det.getImporte()}0</td>
                            </tr>
                        </c:forEach>
                        
                    </tbody>
                </table>
                <h4>------------------------------------------------</h4>
                <h3 class="total">Total: S/${Ticket.getTotal()}</h3>
                <h4>------------------------------------------------</h4>
            </div>
        </div>
        <div>
            <div class="centertick2">
                <h4> </h4>
                <h4>Forma de Pago:  Efectivo  </h4>
                <h4>Fecha: ${Ticket.getSaleDate()}</h4>
                <h4>-------------------------------</h4>
                <h5 class="total_char">---- DOC. SIN VALOR TRIBUTARIO ------</h5>
                <h5 class="total_char">---- GRACIAS POR SU PREFERENCIA -----</h5>
            </div>
        </div>
        <script type="text/javascript">
            (function(){
                    window.print();
            })();
        </script>
    </body>
</html>