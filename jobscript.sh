#!/bin/bash
echo "***reproductor de musica***"
contador=0
while [ $auto_reproducir != false ]
do
	if [ $contador = 5 ]
    then
		echo "---esta fue la ultima cancion de la playlist---"
        auto_reproducir=false
     	sleep 5
    else
    	echo ">>> reproduciendo cancion de $artista" 
    	sleep 5
        contador=$(($contador+1))
    fi
done
echo "***la playlist del genero: $genero se acabo, adios $usuario***"
