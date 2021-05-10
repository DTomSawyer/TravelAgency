<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<
                <form action="${pageContext.request.contextPath}/home/filter" class="hide">
                    <select id="slctCountry" class="border-dark custom-select" style="color: rgb(248,249,250);background-color: #465765;padding-bottom: 0px;padding-top: 0px;margin-top: 6px;margin-bottom: 6px;" name="country">
                        <optgroup label="Choose country">
                            <option value="world" selected>World</option>
                            <c:forEach items="${countries}" var="country">
                                <option value="${country}">${country}</option>
                            </c:forEach>
                        </optgroup>
                    </select>
                    <h6>Pick date</h6>
                    <input  type="date" name="date" id="datePicker" >
                    <h6>How many days you wish to rest?</h6>
                    <input id="daysInputPicker" type="number">
                    <input id="daysRangePicker" name="daysPeriod"  type="range" min="1" max="14" value="1" ><button
                        type="submit" onclick="reload()">Apply</button>
                </form>
            </div>

                <p class="text-left" style="font-size: 12px;color: #f8f9fa;">Free rooms from
                    <fmt:formatDate value="${fromDate}" pattern="MM/dd/yyyy"/>
                    to <fmt:formatDate value="${toDate}" pattern="MM/dd/yyyy"/></p>


                    <c:forEach items="${hotelList}" var="hotel">
                                        <div>${hotel.value} rooms available</span></div>
                                    </div>
                                    <c:if test="${hotel.value != 0}">
                                        <div class="row">
                                            <div class="col"><button onclick="submitOrder(${hotel.key.id})" >Book!</button></div>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<t:footer/>
<script>
    var token =  $('input[name="${_csrf.parameterName}"]').attr('value');
    function submitOrder(hotelId){
        var date = $('#datePicker').val();
        var daysPeriod = $('#daysInputPicker').val();
        $.ajax({
            method:'POST',
            data:{
                date:date,
                daysPeriod:daysPeriod,
                hotelId:hotelId
            },
            headers: {
                'X-CSRF-Token': token
            },
            url:"/home/bookHotel",
            success: funcSuccess
        });
    }
    function funcSuccess() {
        location.reload()
    }
    function reload() {
        localStorage.setItem('selectedCountry',$('#slctCountry').val());
        localStorage.setItem('selectedDate',$('#datePicker').val());
        localStorage.setItem('selectedDays',$('#daysInputPicker').val());
        location.reload(true);
    }
    $(document).ready(function() {
        var selectedCountry = localStorage.getItem('selectedCountry');
        var selectedDate = localStorage.getItem('selectedDate');
        var selectedDays = localStorage.getItem('selectedDays');
        if (selectedCountry){
            $('#slctCountry').val(selectedCountry)
            $('#datePicker').val(selectedDate)
            if(selectedDate === '')
                document.getElementById('datePicker').valueAsDate = new Date()
            $('#daysInputPicker').val(selectedDays)
            $('#daysRangePicker').val(selectedDays)
        }
    });
    $('#daysRangePicker, #daysInputPicker').on('input', function(){
        $(this).siblings('#daysRangePicker, #daysInputPicker').val(this.value);
    });
</script>
</body>

</html>
