function Panel(el, hide) {
    var obj = this, dura = 500, counter = 0, cntFunc; obj.el = el; obj.elem = $(el); if ($.inArray(obj.elem[0].tagName.toLowerCase(), ["ol", "ul"]) > -1) { obj.elem.removeAttr("id").css("display", "").removeClass("hide").removeClass("hidden"); obj.elem = obj.elem.wrap('<div id="'+ el.substring(1) +'"></div>').parent(); } var children = obj.elem.children(), bodyEl = el.substring(1) +'-body', body = obj.elem.append('<div style="'+ (hide == null || hide ? "display: none" : "") +'" id="'+ bodyEl +'"></div>').find("#"+ bodyEl).append(children), progressType, progress = obj.elem.append('<div class="progress" style="display: none"><div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 0%"><span class="sr-only">0% Complete</span></div></div>').find(".progress");
    obj.center = function(){ obj.elem.removeClass(["text-left", "text-right"]).addClass("text-center"); return this }; obj.right = function(){ obj.elem.removeClass(["text-left", "text-center"]).addClass("text-right"); return this }
    obj.hide = function(ms) { if (isHidden()) return this; body.hide(ms || dura); return this }; obj.show = function(ms) { if (!isHidden()) return this; if (!ms || !$.isNumeric(ms)) ms = dura; if (ms >= 0) body.css("display", "none").removeClass("hide").removeClass("hidden").show(ms); else obj.hide(Math.abs(ms)); return this }
    obj.slideDown = function(ms){ if (isHidden()) { body.css("display", "none").removeClass("hide").removeClass("hidden").slideDown(ms || dura, arguments[1] || function(){}) } return this }; obj.slideUp = function(ms){ if (!isHidden()) { body.slideUp(ms || dura, arguments[1] || function(){}) } return this }
    obj.progress = function(){ return { "elem": progress, "show": function(ms){ body.slideUp(ms || 10); progress.slideDown(); return this }, "hide": function(ms){ body.slideDown(ms || 10); progress.slideUp(); return this }
        ,"success": function(){ return this.style("progress-bar-success") }, "info": function(){ return this.style("progress-bar-info") }, "warn": function(){ return this.style("progress-bar-warning") }, "error": function(){ return this.style("progress-bar-danger") }, "plain": function(){ return obj.style("") }, "style": function(clsName) { $(this.elem[0].childNodes[0]).removeClass(progressType).addClass(progressType = clsName); return this }
        ,"percent": function(perc){ if (!$.isNumeric(perc) || (perc > 100 || perc < 0)) return this; this.elem[0].childNodes[0].style.width = perc +"%"; return this }
        ,"timeCnt": function(seconds) { var o = this; this.percent(counter = 0); cntFunc = setInterval(function(){ o.percent(100/seconds * ++counter); if (seconds < counter) { clearInterval(cntFunc); o.hide(1000) } }, 1000); return this }
    } }; function isHidden() { return body.css("display") === "none" || body.hasClass("hide") || body.hasClass("hidden") }; obj.elem.css("display", "").removeClass("hide").removeClass("hidden");
}

function BootstrapTable(el, options) {
    var obj = this, rawData = [], successFunc = function(){}, checkEvt = function(e){ console.log(e) }, uncheckEvt = checkEvt; obj.el = el; obj.elem = $(el).bootstrapTable(options = $.extend({ uniqueId: "id", responseHandler: function(res){ if (!res) return []; if (res.constructor === Array) return res; if (!res.data || res.data.constructor !== Array) return []; return res.data }, onLoadSuccess: function(res){ rawData = res; obj.resetView(400); successFunc(res) }, onCheck: window[el.substring(1) +"CheckEvent"], onUncheck: window[el.substring(1) +"UncheckEvent"], onCheckAll: window[el.substring(1) +"CheckAllEvent"], onUncheckAll: window[el.substring(1) +"UncheckAllEvent"] }, options));
    obj.clear = function() { obj.elem.bootstrapTable("removeAll"); return obj }; obj.remove = function(index){ obj.elem.bootstrapTable("remove", { field: "index", values: [index] }); return this }; obj.resetView = function(ms){ setTimeout(function(){ obj.elem.bootstrapTable("resetView") }, ms || 200); return this }; obj.isEmpty = function(){ return obj.data().length == 0 }
    obj.showLoad = function() { this.elem.bootstrapTable("showLoading"); return this }; obj.hideLoad = function() { this.elem.bootstrapTable("hideLoading"); return this };
    obj.update = function(rec){ var id = rec.id, index = rec.index, row; if ((row = obj.getId(id)) != null) { obj.elem.bootstrapTable("updateRow", { "index": row.index, "row": $.extend(row, rec) }) } else if ((row = obj.data()[index]) != null) { obj.elem.bootstrapTable("updateRow", { "index": index, "row": $.extend(row, rec) }) } else obj.insert(rec); return this }; obj.insert = function(row) { var data = obj.elem.bootstrapTable("getData"); obj.elem.bootstrapTable("insertRow", { "index": data.length, "row": $.extend(row, { "index": data.length }) }); return this }
    obj.find = function(field, value) { var data = obj.elem.bootstrapTable("getData"); return $.map(data, function(o,i){ return o[field] === value ? o : null }) }
    obj.map = function(col) { var resultMap = {}; $.each(obj.data(), function(ind, row){ resultMap[row[col]] = row }); return resultMap }
    obj.rawData = function() { if (arguments.length == 1) { this.elem.bootstrapTable("load", rawData = arguments[0]); return this } return $.map(this.elem.bootstrapTable("getData"), function(row){ return row }) }; obj.getSelections = function(){ return obj.elem.bootstrapTable("getAllSelections") }
    obj.data = function() { var data = []; obj.elem.find("tbody tr").each(function(i,o){ var row = o, record = []; for (var j = 0, n = row.childNodes.length; j < n; j++) { var col = row.childNodes[j], val = ""; if (col.childNodes.length != 1) val = ""; else if (col.childNodes[0].nodeType == 3) val = $.trim(col.childNodes[0].textContent); else if (col.childNodes[0].nodeName == "INPUT") { var elm = col.childNodes[0], isText = elm.type == "text"; val = $.trim(isText ? elm.value : ((elm.type == "checkbox" || elm.type == "radio") && elm.checked ? elm.value : "")) } else if (col.childNodes[0].nodeName == "DIV") val = $.trim(col.childNodes[0].childNodes[0].value); record.push(val) } data.push(record) }); return data };
    obj.selected = function() { var data = []; obj.elem.find("tbody tr").find("input[type=checkbox]:checked, input[type=radio]:checked").each(function(i,o){ var row = o.parentNode.parentNode, record = []; for (var j = 0, n = row.childNodes.length; j < n; j++) { var col = row.childNodes[j], val = ""; if (col.childNodes.length != 1) val = ""; else if (col.childNodes[0].nodeType == 3) val = $.trim(col.childNodes[0].textContent); else if (col.childNodes[0].nodeName == "INPUT") val = $.trim(col.childNodes[0].value); else if (col.childNodes[0].nodeName == "DIV") val = $.trim(col.childNodes[0].childNodes[0].value); record.push(val) } data.push(record) }); return data };
    obj.getId = function(id) { var o = obj.elem.bootstrapTable("getRowByUniqueId", id); if ($.type(o) == "array") return null; return o[options.uniqueId] == id ? o : null }; obj.delId = function(id) { obj.elem.bootstrapTable("removeByUniqueId", id); return this }; // options: { uniqueId: "fieldName" }
    obj.filter = function(func) { var filteredRow, filteredData = []; for (var i = 0, m = rawData.length; i < m; i++) { if (filteredRow = func(rawData[i])) filteredData.push(filteredRow) } obj.elem.bootstrapTable("load", filteredData); return this }
    obj.sum = function(isAll, colName) { var sum = 0; $.each(this.elem.bootstrapTable(isAll ? "getData" : "getSelections"), function(i,o){ sum += (o[colName] || 0) }); return sum };
    obj.sumInput = function(index) { var sum = 0; obj.elem.find("tbody tr").each(function(i,o){ var val = o.children[index].children[0].value.replace(/[,]/g, ""); sum += (!$.isNumeric(val) ? 0 : parseFloat(val, 10)) }); return sum }
    obj.http = function(url, urlParams, succFunc) { if (succFunc) successFunc = succFunc; obj.elem.bootstrapTable("refresh", { "url": url, "query": urlParams }); return this }
    obj.expand = function() { obj.elem.find(".detail-icon i.icon-plus").click(); return this }; obj.collapse = function() { obj.elem.find(".detail-icon i.icon-minus").click(); return this };
    obj.checkAll = function(){ var checked = arguments.length == 0 || arguments[0] == true || ($.type(arguments[0]) == "boolean" ? arguments[0] : arguments[0] == "true"), data = obj.elem.bootstrapTable("getData"); $.each(obj.elem.bootstrapTable("getOptions").columns[0], function(i, col){ if (col.checkbox) $.each(data, function(j, row){ row[col.field] = checked }) }); return this }; obj.uncheckAll = function(){ obj.checkAll(false); return this }
    obj.elem.on("check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table", window[el.substring(1) +"CheckBoxEvent"])
}

//function Listbox(el, url) { 
//	var obj = this, data = [{ key: "", value: "", text: "กรุณาเลือก" }]; obj.el = el; obj.elem = $(el);
//	obj.data = function(array) { if ($.type(array) == "array") { setup(data = array); return this } return data; };
//	obj.init = function(url) { if (url) $.get(url, function(res) { setup(data = res.data) }); else setup(data); return this };
//	obj.index = function() { if (arguments.length == 1) { var maxLen = data.length, index = arguments[0]; obj.elem.find("option").each(function(i, opt){ opt.removeAttribute("selected") }).eq(index < 0 ? maxLen + index : index).attr("selected", true); return this } return $.inArray("selected", obj.elem.find("option").map(function(i, opt){ return opt.selected ? "selected" : "no-selected" })) }
//	obj.selected = function(){ return data[obj.index()]; }; obj.val = function() { return obj.elem.val(); }; obj.key = function(){ if (arguments.length == 0) { var key = obj.elem.find("option:selected").data("key"); if (typeof key === "string" && key === "undefined") { var item = data[obj.index()]; key = item && item.key ? item.key : item.id } return key } var key = arguments[0]; for (var i = 0, m = data.length; i < m; i++) { var item = data[i]; if (item.key && item.key == key) { obj.index(i); break; } if (item.id && item.id == key) { obj.index(i); break; } } return this }
//	function setup(array) { obj.elem.find("*").remove(); obj.elem.append('<option data-index="0" data-key="" value="">กรุณาเลือก</option>'); $.each(array,function(i,o){ obj.elem.append('<option data-index="'+ (i+1) +'" data-key="'+ o.key +'" value="'+ o.key +'">'+ (o.value) +'</option>') }); }
//	data = obj.elem.change(window[el.substring(1) +"OnChange"]).find("option").map(function(i, opt){ return { key: opt.getAttribute("data-key"), value: opt.value, text: opt.textContent } });
//	obj.error = function(flag) { if(flag == true){ obj.elem.parent().addClass("has-error"); return true; }else if(flag == false){ obj.elem.parent().removeClass("has-error"); return false; }else if (obj.val()=='') {obj.elem.parent().addClass("has-error"); return true; }else{ obj.elem.parent().removeClass("has-error"); return false; } }
//}

function Button(el) {
    var obj = this, badge; obj.el = el; obj.elem = $(el);
    obj.hide = function() { this.elem.addClass("hide"); return this }; obj.show = function() { this.elem.removeClass("hide"); return this };
    obj.hideLoad = function(){ obj.elem.button("reset"); return this }; obj.showLoad = function(){ obj.elem.button("loading"); return this };
    obj.disable = function(flag) { if (flag == null || flag) this.elem.addClass("disabled").attr("disabled", true); else this.elem.removeClass("disabled").attr("disabled", false); return this }; obj.enable = function() { obj.disable(false); return this };
    obj.badge = function(val) { if (badge) badge.text(val) }; if ((badge = this.elem.next()).length == 0) badge = null;
    obj.elem.click(window[el.substring(1) +"OnClick"]);
}

function Input(el, maxLen, propPos) {
    var obj = this; obj.el = el; obj.elem = $(el);
    obj.error = function(flag) { if(flag == true){ obj.elem.parent().addClass("has-error"); return true; }else if(flag == false){ obj.elem.parent().removeClass("has-error"); return false; }else if (obj.val()=='') {obj.elem.parent().addClass("has-error"); return true; }else{ obj.elem.parent().removeClass("has-error"); return false; } }
    obj.clear = function() { obj.val(""); return this }; obj.isEmpty = function() { return $.trim(obj.val()) === "" }; obj.isNumeric = function() { return $.isNumeric(obj.val()) }
    obj.nextFocus = function(nextElem) { if (nextElem && "Input|Button".indexOf(nextElem.constructor.name) > -1) { obj.elem.keyup(function(e){ var key = (e.which || e.keyCode || e.charCode || 0); if (key == 13) nextElem.elem.focus(); return true }) } return this };
    obj.click = function(func) { obj.elem.click(func); return this }
    obj.readOnly = function(flag) { obj.elem.attr("readonly", (flag == null ? true : flag)); return this }
    obj.disable = function(flag) { obj.elem.attr("disabled", (flag == null ? true : flag)); return this }
    obj.enable = function() { obj.disable(false); return this }
    obj.val = function() { if (arguments.length == 1) { this.elem.val(arguments[0]) } return $.trim(this.elem.val()) }
    obj.get = function(propName) { if ($.type(propPos[propName]) !== "array" || propPos[propName].length !== 2) return ""; return obj.val().substring(propPos[propName][0], propPos[propName][1]) }
    obj.elem.blur(window[el.substring(1) +"OnBlur"]); obj.elem.keyup(function(e){ var func = (window[el.substring(1) +"OnKeyUp"] || function(){}); func((e.which || e.keyCode || e.charCode || 0), obj.elem) }); obj.elem.focus(function(){ this.select() }); if ($.isNumeric(maxLen)) { obj.elem.attr("maxLength", maxLen) }
}






function Listbox(el, url) {
    var obj = this, data = [ {
        key : "",
        value : "กรุณาเลือก"
    } ];
    obj.el = el;
    obj.elem = $(el);
    obj.data = function(array) {
        if ($.type(array) == "array") {
            setup(data = array);
            return this;
        }
        return data;
    };
    obj.init = function(url) {
        if (url)
            $.get(url, function(res) {alert('type : '+typeof res+', res : '+res);
                data = res;
                data.splice(0, 0, {key : "", value : "กรุณาเลือก"});
                setup(data);
            });
        else
            setup(data);
        return this;
    };
    obj.index = function() {
        if (arguments.length == 1) {
            var maxLen = data.length, index = arguments[0];
            obj.elem.find("option").each(function(i, opt) {
                opt.removeAttribute("selected")
            }).eq(index < 0 ? maxLen + index : index).attr("selected", true);
            return this
        }
        return $.inArray("selected", obj.elem.find("option").map(
            function(i, opt) {
                return opt.selected ? "selected" : "no-selected"
            }))
    }
    obj.selected = function() {
        return data[obj.index()];
    };
    obj.val = function() {
        return obj.elem.val();
    };
    obj.key = function() {
        if (arguments.length == 0) {
            var key = obj.elem.find("option:selected").data("key");
            if (typeof key === "string" && key === "undefined") {
                var item = data[obj.index()];
                key = item && item.key ? item.key : item.id
            }
            return key
        }
        var key = arguments[0];
        for (var i = 0, m = data.length; i < m; i++) {
            var item = data[i];
            if (item.key && item.key == key) {
                obj.index(i);
                break;
            }
            if (item.id && item.id == key) {
                obj.index(i);
                break;
            }
        }
        return this
    }
    function setup(array) {
        obj.elem.find("*").remove();
        $.each(array, function(i, o) {
            obj.elem.append('<option data-index="' + i + '" data-key="'
                + o.key + '" value="' + o.key + '">' + (o.value)
                + '</option>')
        });
    }
    data = obj.elem.change(window[el.substring(1) + "OnChange"]).find("option")
        .map(function(i, opt) {
            return {
                key : opt.getAttribute("data-key"),
                value : opt.value,
                text : opt.textContent
            }
        });
    obj.error = function(flag) {
        if (flag == true) {
            obj.elem.parent().addClass("has-error");
            return true;
        } else if (flag == false) {
            obj.elem.parent().removeClass("has-error");
            return false;
        } else if (obj.val() == '') {
            obj.elem.parent().addClass("has-error");
            return true;
        } else {
            obj.elem.parent().removeClass("has-error");
            return false;
        }
    }
}