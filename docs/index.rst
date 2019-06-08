.. Elasticsearch Fair search documentation master file, created by
   sphinx-quickstart on Thu Sep 28 14:00:10 2017.
   You can adapt this file completely to your liking, but it should at least
   contain the root `toctree` directive.

Fairsearch Plugin for Elasticsearch
===================================

The *Fairsearch* plug-in for Elasticsearch is an implementation of the `FA*IR algorithm <https://arxiv.org/abs/1706.06368>`_. It enables you to apply a *positive action* policy in which elements are re-ranked to ensure a fair representation of minorities or disadvantaged people.

This plugin has been developed by Pere Urbón and, later, by Ivan Kitanovski in collaboration with researchers at TU Berlin and Pompeu Fabra University, with  support from a grant by the `Data Transparency Lab <http://datatransparencylab.org/dtl2017_program_fair/>`_.

Get started
-------------------------------

- Check whether this plug-in is for you: :doc:`theory`, :doc:`plugin`
- Understand the fairness criterion applied: :doc:`theory`
- Use the plug-in to perform a re-ranking: :doc:`usage`
- Advance usage, like build an M table: :doc:`advance`

Installing
-----------

Pre-built versions can be found `here <https://fair-search.github.io/>`_. Want a build for an ES version? Follow the instructions in the `README for building <https://github.com/fair-search/fairsearch-elasticsearch-plugin#development>`_ or `create an issue <https://github.com/fair-search/fairsearch-elasticsearch-plugin/issues>`_. Once you've found a version compatible with your Elasticsearch, you'd run a command such as:

    ./bin/elasticsearch-plugin install \
    https://fair-search.github.io/fair-reranker/fairsearch-1.0-es6.1.2-SNAPSHOT.zip

(It's expected you'll confirm some security exceptions, you can pass -b to elasticsearch-plugin to automatically install)


Heeelp!
-------

- If you have questions or feedback, see :doc:`contact`

Contents
-------------------------------


.. toctree::
   :maxdepth: 3

   theory
   plugin
   usage
   advance
   contact
   :caption: Contents:


Indices and tables
==================

* :ref:`genindex`
* :ref:`search`
