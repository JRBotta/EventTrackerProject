window.addEventListener('load', function(e) {
	console.log('document loaded');
	init();
	document.getElementById('btn').addEventListener('click', create);
	var avg;
	getAvg();

});

function init() {
	getThings();
}

function getThings() {

	var xhr = new XMLHttpRequest();

	var link = "api/enemies";
	xhr.open('GET', link, true);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status < 400) {
			var enemies = JSON.parse(xhr.responseText);
			displayEnemies(enemies);
		}

		if (xhr.readyState === 4 && xhr.status >= 400) {
			console.log("ERRORERRORERRORERRORERRORERRORERRORERROR");
		}
	};
	xhr.send(null);

}
function getAvg() {
	
	var xhr = new XMLHttpRequest();
	
	var link = "api/enemies/avg";
	xhr.open('GET', link, true);
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status < 400) {
			avg = xhr.responseText;
			console.log(avg);
		}
		
		if (xhr.readyState === 4 && xhr.status >= 400) {
			console.log("ERRORERRORERRORERRORERRORERRORERRORERROR");
		}
	};
	xhr.send(null);

	
}

function displayEnemies(enemies) {
	var div = document.getElementById('enemiesDiv');
	div.innerHTML = "";
	var table = document.createElement('table');
	var head = document.createElement('thead');
	var tr = document.createElement('tr');
	for (p in enemies[0]) {
		var th = document.createElement('th');
		th.textContent = p;
		tr.appendChild(th);
	}

	head.appendChild(tr);
	table.appendChild(head);
	var tbody = document.createElement('tbody');
	for (var i = 0; i < enemies.length; i++) {
		var tr2 = document.createElement('tr');
		for (p in enemies[i]) {
			var td = document.createElement('td');
			td.textContent = enemies[i][p];
			td.enemy = enemies[i];
			tr2.appendChild(td);
		}
		tr2.enemy = enemies[i];
		tr2.addEventListener('click', displayEnemy);
		tbody.appendChild(tr2);
	}
	var tr2 = document.createElement('tr');
	var td = document.createElement('td');
	td.textContent = "Average HP";
	tr2.appendChild(td);
	var hold = document.createElement('td');
	tr2.appendChild(hold);
	var td2 = document.createElement('td');
	getAvg();
	console.log(avg);
	td2.textContent = avg;
	tr2.appendChild(td2);
	tbody.appendChild(tr2);
	table.appendChild(tbody);
	div.appendChild(table);
}

function displayEnemy(e) {
	var enemy = e.target.enemy;
	var div = document.getElementById('indDiv');
	div.innerHTML = "";
	var form = document.createElement('form');
	form.id = 'update';
	var ul = document.createElement('ul');
	for (p in enemy) {
		var li = document.createElement('li');
		li.textContent = p + ": " + enemy[p] + "       ";

		if (p !== 'id') {
			var input = document.createElement('input');
			input.name = p;
			li.appendChild(input);
		}
		ul.appendChild(li);
	}
	var submit = document.createElement('button');
	submit.textContent = "Update";
	submit.enemy = enemy;
	submit.addEventListener('click', update);
	var submit2 = document.createElement('button');
	submit2.textContent = "Delete";
	submit2.enemy = enemy;
	submit2.addEventListener('click', demolish);
	form.appendChild(ul);
	form.appendChild(submit);
	form.appendChild(submit2);
	div.appendChild(form);
}
function demolish(e) {
	var enemy = e.target.enemy;
	e.preventDefault();
	var xhr = new XMLHttpRequest();
	var path = "api/enemies/" + enemy.id;
	console.log(path);
	xhr.open("DELETE", path, true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status < 400) {
			getThings();
			var div = document.getElementById('indDiv');
			div.innerHTML = "";
		}
		
		if (xhr.readyState === 4 && xhr.status >= 400) {
			console.log("Enemy not deleted");
		}
	};
	xhr.send(null);
}
function update(e) {
	var form = document.getElementById('update');
	e.preventDefault();
	var enemy = e.target.enemy;
	enemy.hp = form.hp.value;

	enemy.name = form.name.value;

	var xhr = new XMLHttpRequest();
	var path = "api/enemies/" + enemy.id;
	console.log(path);
	xhr.open("PUT", path, true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status < 400) {
			getThings();
			displayEnemy(e);
		}

		if (xhr.readyState === 4 && xhr.status >= 400) {
			console.log("Enemy not updated");
		}
	};
	console.log(JSON.stringify(enemy));
	xhr.send(JSON.stringify(enemy));
}
function create() {
	var form = document.getElementById('create');
	var enemy = {};
	enemy.hp = form.hp.value;
	enemy.name = form.name.value;
	console.log(enemy);

	var xhr = new XMLHttpRequest();
	xhr.open("POST", "api/enemies", true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status < 400) {
			getThings();
		}

		if (xhr.readyState === 4 && xhr.status >= 400) {
			actorData.textContent = "Enemy not created";
		}
	};
	xhr.send(JSON.stringify(enemy));
}