<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/import-taglib.jsp" %>
<title>档案管理</title>
<link rel="stylesheet" href="${ctx}/assets/css/jquery-ui.css"/>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap-datepicker3.css"/>
<link rel="stylesheet" href="${ctx}/assets/css/ui.jqgrid.css"/>
<script src="${ctx}/assets/js/date-time/bootstrap-datepicker.js"></script>
<script src="${ctx}/assets/js/jqGrid/jquery.jqGrid.js"></script>
<script src="${ctx}/assets/js/jqGrid/i18n/grid.locale-cn.js"></script>
<div class="page-header">
    <h1>
        档案管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            档案列表
        </small>
    </h1>
</div>

<div class="row">
    <div class="col-xs-12">
        <table class="table  table-bordered table-hover">
            <thead>
            <tr>
                <th class="center">
                    <label class="pos-rel">
                        <input type="checkbox" class="ace">
                        <span class="lbl"></span>
                    </label>
                </th>
                <th class="detail-col">Details</th>
                <th>Domain</th>
                <th>Price</th>
                <th class="hidden-480">Clicks</th>

                <th>
                    <i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
                    Update
                </th>
                <th class="hidden-480">Status</th>

                <th></th>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td class="center">
                    <label class="pos-rel">
                        <input type="checkbox" class="ace">
                        <span class="lbl"></span>
                    </label>
                </td>

                <td class="center">
                    <div class="action-buttons">
                        <a href="#" class="green bigger-140 show-details-btn" title="Show Details">
                            <i class="ace-icon fa fa-angle-double-down"></i>
                            <span class="sr-only">Details</span>
                        </a>
                    </div>
                </td>

                <td>
                    <a href="#">ace.com</a>
                </td>
                <td>$45</td>
                <td class="hidden-480">3,330</td>
                <td>Feb 12</td>

                <td class="hidden-480">
                    <span class="label label-sm label-warning">Expiring</span>
                </td>

                <td>
                    <div class="hidden-sm hidden-xs btn-group">
                        <button class="btn btn-xs btn-success">
                            <i class="ace-icon fa fa-check bigger-120"></i>
                        </button>

                        <button class="btn btn-xs btn-info">
                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                        </button>

                        <button class="btn btn-xs btn-danger">
                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                        </button>

                        <button class="btn btn-xs btn-warning">
                            <i class="ace-icon fa fa-flag bigger-120"></i>
                        </button>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="center">
                    <label class="pos-rel">
                        <input type="checkbox" class="ace">
                        <span class="lbl"></span>
                    </label>
                </td>

                <td class="center">
                    <div class="action-buttons">
                        <a href="#" class="green bigger-140 show-details-btn" title="Show Details">
                            <i class="ace-icon fa fa-angle-double-down"></i>
                            <span class="sr-only">Details</span>
                        </a>
                    </div>
                </td>

                <td>
                    <a href="#">base.com</a>
                </td>
                <td>$35</td>
                <td class="hidden-480">2,595</td>
                <td>Feb 18</td>

                <td class="hidden-480">
                    <span class="label label-sm label-success">Registered</span>
                </td>

                <td>
                    <div class="hidden-sm hidden-xs btn-group">
                        <button class="btn btn-xs btn-success">
                            <i class="ace-icon fa fa-check bigger-120"></i>
                        </button>

                        <button class="btn btn-xs btn-info">
                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                        </button>

                        <button class="btn btn-xs btn-danger">
                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                        </button>

                        <button class="btn btn-xs btn-warning">
                            <i class="ace-icon fa fa-flag bigger-120"></i>
                        </button>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="center">
                    <label class="pos-rel">
                        <input type="checkbox" class="ace">
                        <span class="lbl"></span>
                    </label>
                </td>

                <td class="center">
                    <div class="action-buttons">
                        <a href="#" class="green bigger-140 show-details-btn" title="Show Details">
                            <i class="ace-icon fa fa-angle-double-down"></i>
                            <span class="sr-only">Details</span>
                        </a>
                    </div>
                </td>

                <td>
                    <a href="#">max.com</a>
                </td>
                <td>$60</td>
                <td class="hidden-480">4,400</td>
                <td>Mar 11</td>

                <td class="hidden-480">
                    <span class="label label-sm label-warning">Expiring</span>
                </td>

                <td>
                    <div class="hidden-sm hidden-xs btn-group">
                        <button class="btn btn-xs btn-success">
                            <i class="ace-icon fa fa-check bigger-120"></i>
                        </button>

                        <button class="btn btn-xs btn-info">
                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                        </button>

                        <button class="btn btn-xs btn-danger">
                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                        </button>

                        <button class="btn btn-xs btn-warning">
                            <i class="ace-icon fa fa-flag bigger-120"></i>
                        </button>
                    </div>

                    <div class="hidden-md hidden-lg">
                        <div class="inline pos-rel">
                            <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown"
                                    data-position="auto">
                                <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                            </button>

                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                <li>
                                    <a href="#" class="tooltip-info" data-rel="tooltip" title=""
                                       data-original-title="View">
																			<span class="blue">
																				<i class="ace-icon fa fa-search-plus bigger-120"></i>
																			</span>
                                    </a>
                                </li>

                                <li>
                                    <a href="#" class="tooltip-success" data-rel="tooltip" title=""
                                       data-original-title="Edit">
																			<span class="green">
																				<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																			</span>
                                    </a>
                                </li>

                                <li>
                                    <a href="#" class="tooltip-error" data-rel="tooltip" title=""
                                       data-original-title="Delete">
																			<span class="red">
																				<i class="ace-icon fa fa-trash-o bigger-120"></i>
																			</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="center">
                    <label class="pos-rel">
                        <input type="checkbox" class="ace">
                        <span class="lbl"></span>
                    </label>
                </td>

                <td class="center">
                    <div class="action-buttons">
                        <a href="#" class="green bigger-140 show-details-btn" title="Show Details">
                            <i class="ace-icon fa fa-angle-double-down"></i>
                            <span class="sr-only">Details</span>
                        </a>
                    </div>
                </td>

                <td>
                    <a href="#">best.com</a>
                </td>
                <td>$75</td>
                <td class="hidden-480">6,500</td>
                <td>Apr 03</td>

                <td class="hidden-480">
                    <span class="label label-sm label-inverse arrowed-in">Flagged</span>
                </td>

                <td>
                    <div class="hidden-sm hidden-xs btn-group">
                        <button class="btn btn-xs btn-success">
                            <i class="ace-icon fa fa-check bigger-120"></i>
                        </button>

                        <button class="btn btn-xs btn-info">
                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                        </button>

                        <button class="btn btn-xs btn-danger">
                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                        </button>

                        <button class="btn btn-xs btn-warning">
                            <i class="ace-icon fa fa-flag bigger-120"></i>
                        </button>
                    </div>

                    <div class="hidden-md hidden-lg">
                        <div class="inline pos-rel">
                            <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown"
                                    data-position="auto">
                                <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                            </button>

                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                <li>
                                    <a href="#" class="tooltip-info" data-rel="tooltip" title=""
                                       data-original-title="View">
																			<span class="blue">
																				<i class="ace-icon fa fa-search-plus bigger-120"></i>
																			</span>
                                    </a>
                                </li>

                                <li>
                                    <a href="#" class="tooltip-success" data-rel="tooltip" title=""
                                       data-original-title="Edit">
																			<span class="green">
																				<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																			</span>
                                    </a>
                                </li>

                                <li>
                                    <a href="#" class="tooltip-error" data-rel="tooltip" title=""
                                       data-original-title="Delete">
																			<span class="red">
																				<i class="ace-icon fa fa-trash-o bigger-120"></i>
																			</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="center">
                    <label class="pos-rel">
                        <input type="checkbox" class="ace">
                        <span class="lbl"></span>
                    </label>
                </td>

                <td class="center">
                    <div class="action-buttons">
                        <a href="#" class="green bigger-140 show-details-btn" title="Show Details">
                            <i class="ace-icon fa fa-angle-double-down"></i>
                            <span class="sr-only">Details</span>
                        </a>
                    </div>
                </td>

                <td>
                    <a href="#">pro.com</a>
                </td>
                <td>$55</td>
                <td class="hidden-480">4,250</td>
                <td>Jan 21</td>

                <td class="hidden-480">
                    <span class="label label-sm label-success">Registered</span>
                </td>

                <td>
                    <div class="hidden-sm hidden-xs btn-group">
                        <button class="btn btn-xs btn-success">
                            <i class="ace-icon fa fa-check bigger-120"></i>
                        </button>

                        <button class="btn btn-xs btn-info">
                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                        </button>

                        <button class="btn btn-xs btn-danger">
                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                        </button>

                        <button class="btn btn-xs btn-warning">
                            <i class="ace-icon fa fa-flag bigger-120"></i>
                        </button>
                    </div>

                    <div class="hidden-md hidden-lg">
                        <div class="inline pos-rel">
                            <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown"
                                    data-position="auto">
                                <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                            </button>

                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                <li>
                                    <a href="#" class="tooltip-info" data-rel="tooltip" title=""
                                       data-original-title="View">
																			<span class="blue">
																				<i class="ace-icon fa fa-search-plus bigger-120"></i>
																			</span>
                                    </a>
                                </li>

                                <li>
                                    <a href="#" class="tooltip-success" data-rel="tooltip" title=""
                                       data-original-title="Edit">
																			<span class="green">
																				<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																			</span>
                                    </a>
                                </li>

                                <li>
                                    <a href="#" class="tooltip-error" data-rel="tooltip" title=""
                                       data-original-title="Delete">
																			<span class="red">
																				<i class="ace-icon fa fa-trash-o bigger-120"></i>
																			</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div><!-- /.span -->
</div>
