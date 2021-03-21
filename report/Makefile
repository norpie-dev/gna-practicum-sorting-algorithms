all: compile clean

open: compile
	zathura report.pdf

compile:
	pdflatex report.tex
	pdflatex report.tex

clean:
	rm -f report.toc report.log report.aux report.bbl report.blg
