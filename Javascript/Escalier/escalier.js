/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var canvas = document.getElementById("canvas_escalier");
var ctx = canvas.getContext("2d");


function rectangles (x, y, l, h, bordure, remplissage) {
    ctx.lineWidth = 3;
    ctx.fillStyle = remplissage;
    ctx.strokeStyle = bordure;
    ctx.fillRect(x, y, l, h);
    ctx.strokeRect(x, y, l, h);
}


function marches(max, h, bordure, remplissage) {

    var x = 0, y = 0;
    var l = h;
    for (var i = 0; i <= max; i++) {
        rectangles(x, y, l, h, bordure, remplissage);
        y = y + h;
        l = l + h;
    }
}
function dessinerPyramide (max, h, bordure, remplissage) {
    var x = canvas.width / 2 - h;
    var y = 0;
    var l = 2* h;
    for (var i = 1; i <= max; i++) {
        rectangles(x, y, l, h, bordure, remplissage);
        y = y + h;
        x = x - h;
        l = l + 2* h;
      }
}
function effacer() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
}

function lancer() {
    document.getElementById("dessiner").onclick = function () {
        var max = parseInt(document.getElementById("nombre").value);
        var h = parseInt(document.getElementById("haut").value);
        var R = document.getElementById("R").value;
        var B = document.getElementById("B").value;
        var Escalier_droit = document.getElementById("Escalier_droit").checked;
          if (Escalier_droit) {
            marches(max, h, B, R);
          } else {
            dessinerPyramide(max, h, B, R);
    }
  };

    document.getElementById("effacer").onclick = function () {
        effacer();
      };
    }
