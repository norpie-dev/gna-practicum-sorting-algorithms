all: compile clean

open: compile clean
	zathura report.pdf

compile:
	latexmk -pdf

clean:
	rm -f report.aux report.dvi report.fls  report.log report.bbl report.blg report.out report.toc report.fdb_latexmk
