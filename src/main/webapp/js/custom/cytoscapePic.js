var drawCytoPic = function(element,id){ 

	var ele = JSON.parse(element);
	
	console.log(ele);
	
	console.log(id);
	console.log(document.getElementById(id));
	var cy = cytoscape({
		  container: document.getElementById(id),
		  
		  style: cytoscape.stylesheet()
		    .selector('node')
		      .css({
		        'font-size': 10,
		        'content': 'data(gene_name)',
		        'text-valign': 'center',
		        'color': 'white',
		        'text-outline-width': 2,
		        'text-outline-color': '#888',
		        'min-zoomed-font-size': 8,
		        'width': 'mapData(score, 0, 1, 20, 50)',
		        'height': 'mapData(score, 0, 1, 20, 50)'
		      })
		    .selector('node[node_type = "notDnb"]')
		      .css({
		        'background-color': '#666',
		        'text-outline-color': '#666'
		      })
		      .selector('node[node_type = "dnb"]')
		      .css({
		    	  'background-color': '#666',
		    	  'text-outline-color': '#666'
		      })
		    .selector('node:selected')
		      .css({
		        'background-color': '#000',
		        'text-outline-color': '#000'
		      })
		    .selector('edge')
		      .css({
		        'curve-style': 'haystack',
		        'opacity': 0.333,
		        'width': 'mapData(normalized_max_weight, 0, 0.01, 1, 2)',
		      })
		    .selector('edge[data_type = "notDnb"]')
		      .css({
		        'line-color': '#C32E2E'
		      })
		    .selector('edge[data_type = "dnb"]')
		      .css({
		        'line-color': '#EAA2A3'
		      })
		  .selector('edge:selected')
		    .css({
		      opacity: 1
		    }),
	  
	  elements:ele,
	  
	  layout: {
	    name: 'concentric',
	    concentric: function(){
	      return this.data('score');
	    },
	    levelWidth: function(nodes){
	      return 0.5;
	    },
	    padding: 10
	  }
	});
	  
}